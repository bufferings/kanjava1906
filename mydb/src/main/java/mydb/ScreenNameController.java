package mydb;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactiverse.reactivex.pgclient.PgIterator;
import io.reactiverse.reactivex.pgclient.PgPool;
import io.reactiverse.reactivex.pgclient.Tuple;
import io.reactivex.Single;

@Controller
public class ScreenNameController {

  private final PgPool client;

  ScreenNameController(PgPool client) {
    this.client = client;
  }

  @Get("{name}")
  public Single<String> getScreenName(String name) {
    return client.rxPreparedQuery(
      "SELECT screen_name FROM speakers WHERE name=$1",
      Tuple.of(name)
    ).map(rows -> {
      PgIterator it = rows.iterator();
      if (it.hasNext()) {
        return it.next().getString("screen_name");
      }
      return name;
    });
  }
}

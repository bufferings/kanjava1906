package demo;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("http://localhost:8081")
public interface ScreenNameClient {
  @Get("/{name}")
  Single<String> getScreenName(String name);
}

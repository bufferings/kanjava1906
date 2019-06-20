package demo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.validation.constraints.Size;

@Controller("/hello")
public class HelloController {

  private final GreetingService greetingService;

  private final ScreenNameClient screenNameClient;

  HelloController(GreetingService greetingService,
                  ScreenNameClient screenNameClient) {
    this.greetingService = greetingService;
    this.screenNameClient = screenNameClient;
  }

  @Get("/b/{name}")
  public String blocking(String name) {
    return screenNameClient.getScreenName(name)
      .flatMap(greetingService::greeting)
      .blockingGet();
  }

  @Get("/r/{name}")
  public Single<String> reactive(@Size(min = 4) String name) {
    return screenNameClient.getScreenName(name)
      .flatMap(greetingService::greeting);
  }
}
package demo;

import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class GreetingService {
  public Single<String> greeting(String name) {
    return Single.just("Hello " + name);
  }
}

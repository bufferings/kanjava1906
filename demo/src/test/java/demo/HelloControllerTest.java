package demo;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloControllerTest {

  @Client("/hello")
  @Inject
  RxHttpClient client;

  @Test
  public void testBlocking() throws Exception {
    assertEquals("Hello キット",
      client.toBlocking().retrieve("/b/kitkat"));
    assertEquals("Hello 椎葉",
      client.toBlocking().retrieve("/b/bufferings"));
  }

  @Test
  public void testReactive() throws Exception {
    assertEquals("Hello キット",
      client.toBlocking().retrieve("/r/kitkat"));
    assertEquals("Hello 椎葉",
      client.toBlocking().retrieve("/r/bufferings"));
    assertEquals("Hello いろふ",
      client.toBlocking().retrieve("/r/irof"));
  }
}

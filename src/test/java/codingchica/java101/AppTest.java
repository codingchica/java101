package codingchica.java101;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Unit tests for the getGreeting method.
     * @see App#getGreeting()
     */
    @Nested
  class GetGreetingTest {
      @Test
      void getGreeting_whenInvoked_thenExpectedResultReturned() {
          // Setup
          String expectedGreeting = "Hello, gorgeous!";
          App app = new App();

          // Execution
          String actualGreeting = app.getGreeting();

          // Validation
          assertEquals(expectedGreeting, actualGreeting, "greeting");
      }
  }
}

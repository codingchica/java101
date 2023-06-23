package codingchica.java101;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Unit tests for the getGreeting method.
     *
     * @see App#getGreeting()
     */
    @Nested
    class GetGreetingTest {
        @ParameterizedTest
        @ValueSource(strings = {"Maddie", "Izzie", "Bob"})
        void getGreeting_whenInvoked_thenExpectedResultReturned(String name) {
            // Setup
            String expectedGreeting = String.format("Hello, %s!", name);
            App app = new App(name);

            // Execution
            String actualGreeting = app.getGreeting();

            // Validation
            assertEquals(expectedGreeting, actualGreeting, () -> String.format("greeting for %s", name));
        }
    }

    /**
     * Unit tests for the main method.
     *
     * @see App#main(String[])
     */
    @Nested
     class MainTest {

        @Test
        void main_whenInvoked_thenNoException() {
            // Setup

            // Execution
            App.main(null);

            // Validation
            // TODO Only tests that the application runs successfully, not the actual behavior.
        }
    }
}

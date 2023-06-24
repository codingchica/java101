package codingchica.java101;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    /**
     * Unit tests for the add method.
     *
     * @see App#add(byte, byte)
     */
    @Nested
    class AddBytesTest {

        @ParameterizedTest
        @CsvSource({"1,2,3", "0,0,0", "-1,1,0", "127,1,128", "127,2,129", "-128,-1,-129", "-128,-2,-130"})
        void add_whenInvoked_thenReturnsExpectedResult(byte value1, byte value2, int expectedResult) {
            // Setup

            // Execution
            int actualResult = App.add(value1, value2);

            // Validation
            assertEquals(expectedResult, actualResult, () -> String.format("%s+%s=%s", value1, value2, expectedResult));
        }
    }

    /**
     * Unit tests for the add method.
     *
     * @see App#add(short, short)
     */
    @Nested
    class AddShortsTest {

        @ParameterizedTest
        @CsvSource({
                // Happy Path - Positive
                "1,2,3",
                // Happy Path - Neutral
                "0,0,0",
                // Happy Path - Negative
                "-1,-1,-2",
                // Edge Case - Upper Bound short
                "1,32766,32767",
                "32766,1,32767",
                // Edge Case - Lower Bound short
                "-1,-32767,-32768",
                "-32767,-1,-32768",
                // Edge Case - Beyond Upper Bound - short
                "1,32767,32768",
                "32767,2,32769",
                // Edge Case - Beyond Lower Bound - short
                "-1,-32768,-32769",
                "-32768,-2,-32770",
                // Edge Case - Minimum short values
                "-32768,-32768,-65536",
                // Edge Case - Maximum short values
                "32767,32767,65534",
        })
        void add_whenInvoked_thenReturnsExpectedResult(short value1, short value2, int expectedResult) {
            // Setup

            // Execution
            int actualResult = App.add(value1, value2);

            // Validation
            assertEquals(expectedResult, actualResult, () -> String.format("%s+%s=%s", value1, value2, expectedResult));
        }
    }
}

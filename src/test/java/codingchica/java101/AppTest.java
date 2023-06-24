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
        @CsvSource({"1,2,3", "0,0,0", "-1,1,0"})
        void add_whenInvoked_thenReturnsExpectedResult(byte value1, byte value2, byte expectedResult) {
            // Setup

            // Execution
            byte actualResult = App.add(value1, value2);

            // Validation
            assertEquals(expectedResult, actualResult, () -> String.format("%s+%s=%s", value1, value2, expectedResult));
        }

        @ParameterizedTest
        @CsvSource({"127,1,-128", "127,2,-127",})
        void add_whenInvokedWithOverflow_thenReturnsIntegerWrapAroundValues(byte value1, byte value2, byte expectedResult) {
            // Setup

            // Execution
            byte actualResult = App.add(value1, value2);

            // Validation
            // TODO - Add logic for error condition rather than returning successfully.
            assertEquals(expectedResult, actualResult, () -> String.format("%s+%s=%s", value1, value2, expectedResult));
        }

        @ParameterizedTest
        @CsvSource({"-128,-1,127", "-128,-2,126",})
        void add_whenInvokedWithUnderflow_thenReturnsIntegerWrapAroundValues(byte value1, byte value2, byte expectedResult) {
            // Setup

            // Execution
            byte actualResult = App.add(value1, value2);

            // Validation
            // TODO - Add logic for error condition rather than returning successfully.
            assertEquals(expectedResult, actualResult, () -> String.format("%s+%s=%s", value1, value2, expectedResult));
        }
    }
}

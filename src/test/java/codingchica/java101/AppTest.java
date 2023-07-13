package codingchica.java101;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        @CsvSource({
                // Happy-Path - Positive
                "1,2,3",
                // Happy-Path - Neutral
                "0,0,0",
                // Happy-Path - Negative
                "-1,-1,-2",
                // Edge Cases - Past Maximum byte
                "127,1,128",
                "2,127,129",
                // Edge Cases - Below Minimum byte
                "-128,-1,-129",
                "-2,-128,-130",
                // Edge Case - Minimum possible byte
                "-128,-128,-256",
                // Edge Case - Maximum possible byte
                "127,127,254",
        })
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

    /**
     * Unit tests for the add method.
     *
     * @see App#add(int, int)
     */
    @Nested
    class AddIntsTest {

        @ParameterizedTest
        @CsvSource({
                // Happy-path - Positive
                "1,2,3",
                // Happy-path - Neutral
                "0,0,0",
                // Happy-path - Negative
                "-1,-1,-2",
                // Edge Case - Upper Bound
                "2147483646,1,2147483647",
                "2,2147483645,2147483647",
                // Edge Case - Lower Bound
                "-2147483647,-1,-2147483648",
                "-2,-2147483646,-2147483648",
                // Edge Case - Beyond Upper Bound - N/A - Exception thrown
                // Edge Case - Beyond Lower Bound - N/A - Exception thrown
        })
        void add_whenInvokedWhereIntResults_thenReturnsExpectedResult(int value1, int value2, int expectedResult) {
            // Setup

            // Execution
            int actualResult = App.add(value1, value2);

            // Validation
            assertEquals(expectedResult, actualResult, () -> String.format("%s+%s=%s", value1, value2, expectedResult));
        }

        @ParameterizedTest
        @CsvSource({
                // Edge case - just beyond upper bound
                "2147483647,1",
                "3,2147483646",
                // Edge case - Maximum possible value
                "2147483647,2147483647"
        })
        void add_whenInvokedForSumOverflow_thenThrowsException(int value1, int value2) {
            // Setup
            String expectedMessage = String.format("int overflow with addends:  %s and %s", value1, value2);

            // Execution
            Executable executable = () -> App.add(value1, value2);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable, () -> String.format("%s+%s", value1, value2));
            assertEquals(expectedMessage, exception.getMessage(), "IllegalArgumentException message");
        }


        @ParameterizedTest
        @CsvSource({
                // Edge case - just beyond lower bound
                "-2147483648,-1",
                // Swapping large/small order and further beyond lower bound
                "-3,-2147483647",
        })
        void add_whenInvokedForSumUnderflow_thenThrowsException(int value1, int value2) {
            // Setup
            String expectedMessage = String.format("int underflow with addends:  %s and %s", value1, value2);

            // Execution
            Executable executable = () -> App.add(value1, value2);

            // Validation
            Exception exception = assertThrows(IllegalArgumentException.class, executable, () -> String.format("%s+%s", value1, value2));
            assertEquals(expectedMessage, exception.getMessage(), "IllegalArgumentException message");
        }
    }

    @Nested
class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"Sally", "Suzie", "Billy"})
    void getName_whenPopulatedFromConstructor_thenReturnsExpectedValue(String name) {
        // Setup
        App app = new App(name);

        // Execution
        String actualGreeting = app.getName();

        // Validation
        assertEquals(name, actualGreeting);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rachel", "Jeannine", "Andrew"})
    void getName_whenPopulatedFromSetter_thenReturnsExpectedValue(String name) {
        // Setup
        App app = new App("Pattie");
        app.setName(name);

        // Execution
        String actualGreeting = app.getName();

        // Validation
        assertEquals(name, actualGreeting);
    }
}
}

package codingchica.java101.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit tests for the AgeUnits enum.
 */
class AgeUnitsTest {
    /**
     * Unit tests for the values method, to ensure that the expected enum values have been configured in our code.
     */
    @Nested
    class ValuesTest {
        @Test
        void values_whenInvoked_returnsExpectedValues(){
            // Setup
            AgeUnits[] expectedValues = new AgeUnits[]{AgeUnits.YEARS, AgeUnits.DAYS, AgeUnits.HOURS};

            // Execution
            AgeUnits[] values = AgeUnits.values();

            // Validation
            assertArrayEquals(expectedValues, values, () -> String.format("Expected: %s, Actual: %s", Arrays.toString(expectedValues), Arrays.toString(values)));
        }
    }
}
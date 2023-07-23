package codingchica.java101.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Animal class.
 */
class AnimalTest {

    /**
     * An instance of the object under test.
     */
    private Animal animal = new Animal();

    /**
     * Unit tests for the no-argument constructor.
     */
    @Nested
    class NoArgConstructorTest {
        @Test
        void noArgConstructor_whenInvoked_returnsObject() {
            // Setup

            // Execution
            Animal animal = new Animal();

            // Validation
            assertNotNull(animal);
        }
    }

    /**
     * Unit tests for the timeOfBirth field's getters/setters.
     * @see Animal#getTimeOfBirth()
     * @see Animal#setTimeOfBirth(Instant)
     */
    @Nested
    class TimeOfBirthTest {
        @Test
        void getTimeOfBirth_whenDefaultedInConstructor_thenReturnsExpectedValue() {
            // Setup

            // Execution
            Instant result = animal.getTimeOfBirth();

            // Validation
            assertNull(result);
        }

        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getName_whenPopulatedFromSetter_thenReturnsExpectedValue(RelativeTime value) {
            // Setup
            Instant expectedValue = value.getInstant();
            animal.setTimeOfBirth(expectedValue);

            // Execution
            Instant result = animal.getTimeOfBirth();

            // Validation
            assertSame(expectedValue, result);
        }
    }

    /**
     * Unit test for the getAgeInYears method.
     * @see Animal#getAgeInYears()
     */
    @Nested
    class GetAgeInYearsTest {

        @Test
        void getAgeInYears_whenNull_thenReturnsExpectedValue(){
            // Setup
            long expectedResult = -1;

            // Execution
            long result = animal.getAgeInYears();

            // Validation
            assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getAgeInYears_whenInvokedWithTimeOfBirthSet_thenReturnsExpectedValue(RelativeTime value){
            // Setup
            animal.setTimeOfBirth(value.getInstant());
            long expectedResult = switch (value){
                case TEN_YEARS_AGO -> -10;
                case YEAR_AGO -> -1;
                case DAY_AGO,HOUR_AGO, HOUR_AHEAD, DAY_AHEAD -> 0;
                case YEAR_AHEAD -> 1;
                case TEN_YEARS_AHEAD -> 10;
            };

            // Execution
            long result = animal.getAgeInYears();

            // Validation
            assertEquals(expectedResult, result, () -> String.format("%s: %s", value, value.getDurationString()));
        }
    }


    /**
     * Unit test for the getAgeInDays method.
     * @see Animal#getAgeInDays()
     */
    @Nested
    class GetAgeInDaysTest {

        @Test
        void getAgeInDays_whenNull_thenReturnsExpectedValue(){
            // Setup
            long expectedResult = -1;

            // Execution
            long result = animal.getAgeInDays();

            // Validation
            assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getAgeInDays_whenTimeOfBirthPopulated_thenReturnsExpectedValue(RelativeTime value){
            // Setup
            animal.setTimeOfBirth(value.getInstant());
            long expectedResult = switch (value){
                case TEN_YEARS_AGO -> -3750;
                case YEAR_AGO -> -366;
                case DAY_AGO -> -1;
                case HOUR_AGO, HOUR_AHEAD -> 0;
                case DAY_AHEAD -> 1;
                case YEAR_AHEAD -> 365;
                case TEN_YEARS_AHEAD -> 3750;
            };

            // Execution
            long result = animal.getAgeInDays();

            // Validation
            assertEquals(expectedResult, result, () -> String.format("%s: %s", value, value.getDurationString()));
        }
    }


    /**
     * Unit test for the getAgeInHours method.
     * @see Animal#getAgeInHours()
     */
    @Nested
    class GetAgeInHoursTest {

        @Test
        void getAgeInHours_whenNull_thenReturnsExpectedValue(){
            // Setup
            long expectedResult = -1;

            // Execution
            long result = animal.getAgeInHours();

            // Validation
            assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getAgeInHours_whenTimeOfBirthPopulated_thenReturnsExpectedValue(RelativeTime value){
            // Setup
            animal.setTimeOfBirth(value.getInstant());
            long expectedResult = switch (value){
                case TEN_YEARS_AGO -> -90000;
                case YEAR_AGO -> -8784;
                case DAY_AGO -> -24;
                case HOUR_AGO -> -1;
                case HOUR_AHEAD -> 1;
                case DAY_AHEAD -> 28;
                case YEAR_AHEAD -> 8783;
                case TEN_YEARS_AHEAD -> 90000;
            };

            // Execution
            long result = animal.getAgeInHours();

            // Validation
            assertEquals(expectedResult, result, () -> String.format("%s: %s", value, value.getDurationString()));
        }
    }

    /**
     * Unit tests for the getAge method.
     * @see Animal#getAge(AgeUnits)
     */
    @Nested
    class GetAgeTest {
        @Test
        void getAge_whenNull_thenReturnsExpectedValue(){
            // Setup
            long expectedResult = -1;

            // Execution
            long result = animal.getAge(AgeUnits.YEARS);

            // Validation
            assertEquals(expectedResult, result);
        }

        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getAge_whenYears_thenReturnsExpectedValue(RelativeTime value){
            // Setup
            animal.setTimeOfBirth(value.getInstant());
            long expectedResult = switch (value){
                case TEN_YEARS_AGO -> -10;
                case YEAR_AGO -> -1;
                case DAY_AGO,HOUR_AGO, HOUR_AHEAD, DAY_AHEAD -> 0;
                case YEAR_AHEAD -> 1;
                case TEN_YEARS_AHEAD -> 10;
            };

            // Execution
            long result = animal.getAge(AgeUnits.YEARS);

            // Validation
            assertEquals(expectedResult, result, () -> String.format("%s: %s", value, value.getDurationString()));
        }

        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getAge_whenDays_thenReturnsExpectedValue(RelativeTime value){
            // Setup
            animal.setTimeOfBirth(value.getInstant());
            long expectedResult = switch (value){
                case TEN_YEARS_AGO -> -3750;
                case YEAR_AGO -> -366;
                case DAY_AGO -> -1;
                case HOUR_AGO, HOUR_AHEAD -> 0;
                case DAY_AHEAD -> 1;
                case YEAR_AHEAD -> 365;
                case TEN_YEARS_AHEAD -> 3750;
            };

            // Execution
            long result = animal.getAge(AgeUnits.DAYS);

            // Validation
            assertEquals(expectedResult, result, () -> String.format("%s: %s", value, value.getDurationString()));
        }


        @ParameterizedTest
        @EnumSource(value = RelativeTime.class, mode = EnumSource.Mode.EXCLUDE, names = {})
        void getAge_whenHours_thenReturnsExpectedValue(RelativeTime value){
            // Setup
            animal.setTimeOfBirth(value.getInstant());
            long expectedResult = switch (value){
                case TEN_YEARS_AGO -> -90000;
                case YEAR_AGO -> -8784;
                case DAY_AGO -> -24;
                case HOUR_AGO -> -1;
                case HOUR_AHEAD -> 1;
                case DAY_AHEAD -> 28;
                case YEAR_AHEAD -> 8783;
                case TEN_YEARS_AHEAD -> 90000;
            };

            // Execution
            long result = animal.getAge(AgeUnits.HOURS);

            // Validation
            assertEquals(expectedResult, result, () -> String.format("%s: %s", value, value.getDurationString()));
        }
    }
}
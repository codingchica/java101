package codingchica.java101.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;

/**
 * A class to model a real-world animal.
 */
public class Animal {
    /**
     * Ignoring leap year, how many days are in most years.
     */
    private static final int AVERAGE_DAYS_IN_YEAR = 365;

    /**
     * The date and time at which the animal was born or hatched.
     */
    @Getter
    @Setter
    private Instant timeOfBirth = null;

    /**
     * Retrieve the age for the animal.  An animal that has not yet been born
     * will have a negative age.
     *
     * @param unit The unit of time in which the age returned should be
     *             measured.
     * @return The age of the animal in the units provided, or a negative
     * number if the animal has not yet been born or hatched.
     */
    public long getAge(final AgeUnits unit) {
        long age = -1;
        if (timeOfBirth != null) {
            Instant now = Instant.now();
            Duration difference = Duration.between(now, timeOfBirth);
            System.out.println(difference.toString());
            age = switch (unit) {
                case YEARS -> difference.toDays() / AVERAGE_DAYS_IN_YEAR;
                case DAYS -> difference.toDays();
                case HOURS -> difference.toHours();
            };
        }
        return age;
    }
}

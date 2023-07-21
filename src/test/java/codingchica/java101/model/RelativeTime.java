package codingchica.java101.model;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * Relative times to use during testing.
 */
public enum RelativeTime {
    /**
     * Approximately ten years in the past.
     */
    TEN_YEARS_AGO("-P3750D"),
    /**
     * Approximately one year in the past.
     */
    YEAR_AGO("-P366D"),
    /**
     * Approximately one day in the past.
     */
    DAY_AGO("-P1D"),
    /**
     * Approximately one hour in the past.
     */
    HOUR_AGO("-PT1H10M"),
    /**
     * Approximately one hour in the future.
     */
    HOUR_AHEAD("PT1H10M"),
    /**
     * Approximately one day in the future.
     */
    DAY_AHEAD("P1DT5H"),
    /**
     * Approximately one year in the future.
     */
    YEAR_AHEAD("P366D"),
    /**
     * Approximately ten years in the future.
     */
    TEN_YEARS_AHEAD("P3750DT1H");

    /**
     * The date / time value to represent this scenario.
     */
    @Getter
    private final Instant instant;

    @Getter
    private final String durationString;

    /**
     * Private constructor for the enum objects.
     * @param durationStringValue The string representing the desired duration.
     */
    RelativeTime(String durationStringValue){
        durationString = durationStringValue;
        Duration durationValue;
        try {
            durationValue = Duration.parse(durationString);
        } catch (DateTimeParseException e){
            System.out.printf("Unable to parse duration value: %s%n", durationString);
            throw e;
        }

        Instant instantValue = Instant.now();
        instant = instantValue.plus(durationValue);
    }
}

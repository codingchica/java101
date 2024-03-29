package codingchica.java101.model;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

/** A class to model a real-world animal. */
public class Animal {
  /** Ignoring leap year, how many days are in most years. */
  private static final int AVERAGE_DAYS_IN_YEAR = 365;

  /** The date and time at which the animal was born or hatched. */
  @Getter @Setter private Instant timeOfBirth = null;

  /**
   * Retrieve the age for the animal in years. An animal that has not yet been born will have a
   * negative age.
   *
   * @return The age of the animal in years, or a negative number if the animal has not yet been
   *     born or hatched.
   * @deprecated As of 0.1, replaced by {@link #getAge(AgeUnits)}
   */
  @Deprecated(since = "0.1", forRemoval = false)
  public long getAgeInYears() {
    long age = -1;
    if (timeOfBirth != null) {
      Instant now = Instant.now();
      Duration difference = Duration.between(now, timeOfBirth);
      age = difference.toDays() / AVERAGE_DAYS_IN_YEAR;
    }
    return age;
  }

  /**
   * Retrieve the age for the animal in days. An animal that has not yet been born will have a
   * negative age.
   *
   * @return The age of the animal in days, or a negative number if the animal has not yet been born
   *     or hatched.
   * @deprecated As of 0.1, replaced by {@link #getAge(AgeUnits)}
   */
  @Deprecated(since = "0.1", forRemoval = false)
  public long getAgeInDays() {
    long age = -1;
    if (timeOfBirth != null) {
      Instant now = Instant.now();
      Duration difference = Duration.between(now, timeOfBirth);
      age = difference.toDays();
    }
    return age;
  }

  /**
   * Retrieve the age for the animal in hours. An animal that has not yet been born will have a
   * negative age.
   *
   * @return The age of the animal in days, or a negative number if the animal has not yet been born
   *     or hatched.
   * @deprecated As of 0.1, replaced by {@link #getAge(AgeUnits)}
   */
  @Deprecated(since = "0.1", forRemoval = false)
  public long getAgeInHours() {
    long age = -1;
    if (timeOfBirth != null) {
      Instant now = Instant.now();
      Duration difference = Duration.between(now, timeOfBirth);
      age = difference.toHours();
    }
    return age;
  }

  /**
   * Retrieve the age for the animal. An animal that has not yet been born will have a negative age.
   *
   * @param unit The unit of time in which the age returned should be measured.
   * @return The age of the animal in the units provided, or a negative number if the animal has not
   *     yet been born or hatched.
   */
  public long getAge(final AgeUnits unit) {
    long age = -1;
    if (timeOfBirth != null) {
      Instant now = Instant.now();
      Duration difference = Duration.between(now, timeOfBirth);
      age =
          switch (unit) {
            case YEARS -> difference.toDays() / AVERAGE_DAYS_IN_YEAR;
            case DAYS -> difference.toDays();
            case HOURS -> difference.toHours();
          };
    }
    return age;
  }

  /**
   * A string representation of the Animal class.
   *
   * @return A string representing the data in this instance of the Animal class.
   */
  @Override
  public String toString() {
    // TODO improve the performance of this code once we discuss the
    //  better approaches.
    return "Animal{" + "timeOfBirth=" + timeOfBirth + '}';
  }
}

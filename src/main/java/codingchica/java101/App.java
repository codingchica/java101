package codingchica.java101;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/** Hello world! */
public class App {
  /** The initial capacity expected for a greeting String. */
  private static final int INITIAL_GREETING_CAPACITY = 50;

  /**
   * Add two byte values.
   *
   * @param byteValue1 The first value to add.
   * @param byteValue2 The second value to add.
   * @return An int value representing the two values added together.
   */
  public static int add(final byte byteValue1, final byte byteValue2) {
    return byteValue1 + byteValue2;
  }

  /**
   * Add two short values.
   *
   * @param shortValue1 The first value to add.
   * @param shortValue2 The second value to add.
   * @return An int value representing the two values added together.
   */
  public static int add(final short shortValue1, final short shortValue2) {
    return shortValue1 + shortValue2;
  }

  /**
   * Add two int values.
   *
   * @param intValue1 The first value to add.
   * @param intValue2 The second value to add.
   * @return An int value representing the two values added together.
   */
  public static int add(final int intValue1, final int intValue2) {
    long sum = (long) intValue1 + (long) intValue2;
    if (sum < Integer.MIN_VALUE) {
      throw new IllegalArgumentException(
          String.format("int underflow with addends:  %s and %s", intValue1, intValue2));
    } else if (sum > Integer.MAX_VALUE) {
      throw new IllegalArgumentException(
          String.format("int overflow with addends:  %s and %s", intValue1, intValue2));
    }
    return (int) sum;
  }

  /**
   * Constructor for the App class.
   *
   * @param newName The name to use in the application's execution.
   */
  public App(final @NonNull String newName) {
    this.name = newName;
  }

  /** The name of the user of the application. */
  @Getter @Setter @NonNull private String name;

  /**
   * Retrieve the greeting that should be outputted when the application is run.
   *
   * @return The greeting to output.
   */
  public String getGreeting() {
    return String.format("Hello, %s!", this.name);
  }

  /**
   * A utility function to generate a greeting for multiple names.
   *
   * @param namesToGreet The list of names to include in the greeting
   * @return A greeting in english with names, if available.
   */
  public static String getGreetingForMultipleNames(String[] namesToGreet) {
    StringBuilder stringBuilder = new StringBuilder(INITIAL_GREETING_CAPACITY);
    String prefix = "Hello";

    stringBuilder.append(prefix);
    if (namesToGreet != null) {
      List<String> distinctNames =
          Arrays.stream(namesToGreet)
              .filter(Objects::nonNull) // Filter out null values
              .filter(item -> !item.isBlank()) // Filter out blank strings
              .distinct() // Filter out duplicate values
              .sorted() // Alphabetized
              .toList(); // Save as a list

      String lastValue =
          distinctNames.stream()
              .reduce((first, second) -> second) // Find last value
              .orElseGet(() -> null); // Default to null

      distinctNames.forEach(
          name -> {
            // Separate names with a comma
            if (stringBuilder.length() > prefix.length()) {
              stringBuilder.append(',');
            }

            // Space between each segment
            stringBuilder.append(' ');

            // The last name should be preceded with and
            if (lastValue != null && lastValue.equals(name)) {
              stringBuilder.append("and ");
            }

            stringBuilder.append(name);
          });
    }
    stringBuilder.append('!');

    return stringBuilder.toString();
  }

  /**
   * The main entry-point into the application.
   *
   * @param args Command-line arguments - not currently used.
   */
  public static void main(final String[] args) {
    App app = new App("Maddie");
    System.out.println(app.getGreeting());
  }
}

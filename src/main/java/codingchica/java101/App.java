package codingchica.java101;

/**
 * Hello world!
 */
public class App {
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
            throw new IllegalArgumentException(String.format(
                    "int underflow with addends:  %s and %s", intValue1,
                    intValue2));
        } else if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(String.format(
                    "int overflow with addends:  %s and %s", intValue1,
                    intValue2));
        }
        return (int) sum;
    }

    /**
     * Constructor for the App class.
     *
     * @param newName The name to use in the application's execution.
     */
    public App(final String newName) {
        this.name = newName;
    }

    /**
     * The name of the user of the application.
     */
    private String name;

    /**
     * Getter for the name field.
     * @return The current value of the name field.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the newName field.
     * @param newName The new value for the name field.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Retrieve the greeting that should be outputted when the application is
     * run.
     *
     * @return The greeting to output.
     */
    public String getGreeting() {
        return String.format("Hello, %s!", this.name);
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

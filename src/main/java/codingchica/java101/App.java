package codingchica.java101;

/**
 * Hello world!
 */
public class App {

    /**
     * Constructor for the App class.
     * @param name The name to use in the application's execution.
     */
    public App(String name) {
        this.name = name;
    }

    /**
     * The name of the user of the application.
     */
    private String name;

    /**
     * Retrieve the greeting that should be outputted when the application is run.
     * @return The greeting to output.
     */
    public String getGreeting() {
        return String.format("Hello, %s!", this.name);
    }

    /**
     * The main entry-point into the application.
     * @param args Command-line arguments - not currently used.
     */
    public static void main(String[] args) {
        App app = new App("Maddie");
        System.out.println(app.getGreeting());
    }
}

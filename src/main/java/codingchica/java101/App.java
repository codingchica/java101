package codingchica.java101;

/**
 * Hello world!
 */
public class App {
    /**
     * Retrieve the greeting that should be outputted when the application is run.
     * @return The greeting to output.
     */
    public String getGreeting() {
        return "Hello, gorgeous!";
    }

    /**
     * The main entry-point into the application.
     * @param args Command-line arguments - not currently used.
     */
    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());
    }
}

package codingchica.java101.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Animal class.
 */
class AnimalTest {

    @Nested
    class NoArgConstructor {
        @Test
        void noArgConstructor_whenInvoked_returnsObject() {
            // Setup

            // Execution
            Animal animal = new Animal();

            // Validation
            assertNotNull(animal);
        }
    }
}
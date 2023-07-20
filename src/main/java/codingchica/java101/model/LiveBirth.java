package codingchica.java101.model;

/**
 * An animal that has a live birthing process can create animal that are
 * immediately able to perform their own, possibly limited, actions.
 */
public interface LiveBirth {
    /**
     * Determine whether the animal is currently pregnant (able to give
     * birth).  This is, of course, a huge over-simplification, as actual
     * animals would be pregnant for a while before they are able to give birth.
     *
     * @return A boolean value indicating whether the animal is able to give
     * birth.
     */
    boolean isPregnant();

    /**
     * The process of creating a new, distinct animal, for which the age will
     * initially be set to 0.
     *
     * @return An array containing zero or more new animals.
     */
    Animal[] giveBirth();
}

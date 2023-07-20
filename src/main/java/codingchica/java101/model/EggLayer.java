package codingchica.java101.model;

/**
 * An EggLayers create eggs (shells of new animals) but they are not
 * fully usable until they hatch.
 */
public interface EggLayer {
    /**
     * Whether or not an animal can, at present, lay eggs.
     *
     * @return A boolean value indicating if the animal is currently
     * capable of laying eggs.
     */
    boolean canLayEggs();

    /**
     * Create new shell animals, so we can track them until they hatch.
     * Before they hatch, ages should be negative.
     *
     * @return An array containing zero or more animals.
     */
    Animal[] layEggs();
}

package alibabadi.com.custom.androidutil.OtherUtilities;

import java.util.Random;

/**
 * @author Ali Babadi 6/21/2017
 */

public final class RandomHelper {


    /**
     * Method for Integer Random Number
     *
     * @param random   obj {@link Random}
     * @param minValue minimum value {@link Integer}
     * @param maxValue maximum value {@link Integer}
     * @return a random Integer value with parameters given
     */

    public static int randInt(Random random, int minValue, int maxValue) {
        return minValue + (maxValue - minValue) * random.nextInt();
    }


    /**
     * Method for Float Random Number
     *
     * @param random   obj {@link Random}
     * @param minValue minimum value {@link Float}
     * @param maxValue maximum value {@link Float}
     * @return a random Integer value with parameters given
     */

    public static float randFloat(Random random, float minValue, float maxValue) {
        return minValue + (maxValue - minValue) * random.nextFloat();
    }


    /**
     * Method for Double Random Number
     *
     * @param random   obj {@link Random}
     * @param minValue minimum value {@link Double}
     * @param maxValue maximum value {@link Double}
     * @return a random Double value with parameters given
     */

    public static double randDouble(Random random, double minValue, double maxValue) {
        return minValue + (maxValue - minValue) * random.nextDouble();
    }


    /**
     * Method for Long Random Number
     *
     * @param random   obj {@link Random}
     * @param minValue minimum value {@link Long}
     * @param maxValue maximum value {@link Long}
     * @return a random Long value with parameters given
     */

    public static long randLong(Random random, long minValue, long maxValue) {
        return minValue + (maxValue - minValue) * random.nextLong();
    }
}

/**
 * This Class Sorts an Array with the Cocktail Sort Algorithm and returns the values to the Interface Algorithm
 * The CocktailSort is a stable Algorithm
 *
 * @author Philip Jovanovic
 * @version 2.0
 * @since 2021-01-24
 */
public class CocktailSort extends Algorithm {

    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private long time = 0,
                 storage = 0,
                 comparisons = 0,
                 arrayAccess = 0;

    /**
     * @param array Method sort goes through the array given from its superclass and
     *              iterates through it and swaps the position until the array is sorted,
     *              this is done by the CocktailSort Algorithm.
     */
    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        storage = 32 * array.length + 32 * 3 + 8;
        boolean swap = true;
        int beginning = 0;
        int end = array.length;

        while (swap == true) {
            swap = false;
            for (int i = beginning; i < end - 1; i++) {
                comparisons++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    arrayAccess += 2;
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false)
                break;
            swap = false;

            end = end - 1;

            for (int i = end - 1; i >= beginning; i--) {
                comparisons++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    arrayAccess += 2;
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            beginning = beginning + 1;
        }
        long endTime = System.nanoTime();
        time = (long) (endTime - startTime);

    }

    /**
     * The value time evaluates the time, that is taken, in order to sort the array.
     * The value in time is then returned through the method getTime to its superclass Algorithm.
     */
    @Override
    public long getTime() {
        return time;
    }

    /**
     * @return The comparisons that the Algorithm made in the array, for example is 1 > 2.
     */
    @Override
    public long getComparison() {
        return comparisons;
    }

    /**
     * @return The times the array was accessed through the Methods
     */
    @Override
    public long getArrayAccess() {
        return arrayAccess;
    }

    /**
     * @return The amount of storage that has been used for this algorithm.
     */
    @Override
    public long getStorage() {
        return storage;
    }
}


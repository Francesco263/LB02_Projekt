/**
 * This Class Sorts an Array with the Cocktail Sort Algorithm and returns the values to the Interface Algorithm
 * The CocktailSort is a stable Algorithm
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 2.0
 */
public class CocktailSort extends Algorithm {

    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private static int arrayAccess = 0;

    /**
     * @param array
     * Method sort goes through the array given from its superclass and
     * iterates through it and swaps the position until the array is sorted,
     * this is done by the CocktailSort Algorithm.
     */
    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        storage = 32 * 2 + 32 + 8;
        boolean swap = true;
        int beginning = 0;
        int end = array.length;

        while (swap == true){
            arrayAccess += 6;
            swap = false;
            for (int i = beginning; i < end - 1; i++) {
                comparisons++;
                if (array[i] > array[i + 1]){
                    int temp = array[i];
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
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            beginning = beginning + 1;
        }
        long endTime = System.nanoTime();
        time = (int)(endTime - startTime);

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
     *
     * @return
     * The comparisons that the Algorithm made in the array, for example is 1 > 2.
     */
    @Override
    public int getComparison() {
        return comparisons;
    }

    /**
     *
     * @return
     * The times the array was accessed through the Methods
     */
    @Override
    public int getArrayAccess() {
        return arrayAccess;
    }

    /**
     *
     * @return
     * The amount of storage that has been used for this algorithm.
     */
    @Override
    public int getStorage() {
        return storage;
    }
}


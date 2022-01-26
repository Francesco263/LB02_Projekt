/**
 * This Class Sorts an Array with the Bubble Sort Algorithm and returns the values to the Interface Algorithm
 * The BubbleSort is a stable Algorithm
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 2.0
 */
public class BubbleSort extends Algorithm{

    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private long time = 0;
    private long storage = 0;
    private long comparisons = 0;
    private long arrayAccess = 0;

    /**
     * @param array
     * Method sort goes through the array given from its superclass and
     * iterates through it and swaps the position until the array is sorted,
     * this is done by the BubbleSort Algorithm.
     */
    @Override
    public void sort(int[] array) {
        int i;
        int j = 0;
        int temp;
        int n = array.length;
        boolean sorted;
        sorted = true;
        storage = n * 32 + 4 * 32 + 8;
        long start = System.nanoTime();

        for (i = 0; i < n-1; i++){
            for (j = 0; j < n-i-1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    sorted = false;
                    arrayAccess += 2;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }


        long end = System.nanoTime();
        time = (int) (end - start);

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
    public long getComparison() {
        return comparisons;
    }

    /**
     *
     * @return
     * The times the array was accessed through the Methods
     */
    @Override
    public long getArrayAccess() {
        return arrayAccess;
    }

    /**
     *
     * @return
     * The amount of storage that has been used for this algorithm.
     */
    @Override
    public long getStorage() {
        return storage;
    }
}
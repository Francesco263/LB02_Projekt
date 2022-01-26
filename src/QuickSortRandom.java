import java.util.Random;

/**
 * This Class Sorts an Array with the Quick Sort Algorithm using a random value in the array as the pivot
 * and returns the values to the Interface Algorithm.
 * The QuickSort is not a stable Algorithm
 *
 * @author Philip Jovanovic
 * @version 2.0
 * @since 2021-01-18
 */
public class QuickSortRandom extends Algorithm {

    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private long time = 0;
    private long storage = 0;
    private long comparisons = 0;
    private long arrayAccess = 0;

    /**
     * takes array from Interface Algorithm
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        int n = array.length;
        storage = n * 32 + 5 * 32;
        long start = System.nanoTime();
        _quickSort(array, 0, array.length - 1);
        long end = System.nanoTime();
        time = (int) (end - start);
    }

    /**
     * checks if more than 1 item is to be sorted, gets new pivot value
     * call quicksort on left and right side
     *
     * @param array
     * @param low
     * @param high
     */
    private void _quickSort(int[] array, int low, int high) {
        if (low < high + 1) {
            int split = split(array, low, high);
            _quickSort(array, low, split - 1);
            _quickSort(array, split + 1, high);
        }
    }

    /**
     * swaps the values given to the numbers, respectably value1 and value2
     *
     * @param array
     * @param value1
     * @param value2
     */
    private void swapValues(int[] array, int value1, int value2) {
        arrayAccess += 3;
        int temp = array[value1];
        array[value1] = array[value2];
        array[value2] = temp;
    }

    /**
     * picks a random pivot
     *
     * @param low
     * @param high
     * @return
     */
    public int pivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    /**
     * splits the array and calls method swapvalues().
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    private int split(int[] array, int low, int high) {
        swapValues(array, low, pivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (array[i] < array[low]) {
                comparisons++;
                swapValues(array, i, border++);
            }
        }
        swapValues(array, low, border - 1);
        return border - 1;

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

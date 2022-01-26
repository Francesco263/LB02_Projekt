/**
 * This Class Sorts an Array with the Insertion Sort Algorithm and returns the values to the Interface Algorithm
 * The InsertionSort is a stable Algorithm
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 2.0
 */
public class InsertionSort extends Algorithm {

    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;

    /**
     *
     * @param array
     * Sorts the Array with the sort method and swaps the values in the method
     */
    @Override
    public void sort(int[] array) {
        storage = 32 * array.length + 32 * 3;
        long start = System.nanoTime();

        int lenght = array.length;
        for (int i = 1; i < lenght; i++) {
            comparisons++;
            storage += 32;
            int index = array[i];
            arrayAccess++;
            int j = array[i];
            for (j = 1 - 1; (j >= 0) && (index < array[j]) ; j--) {
                comparisons++;
                arrayAccess++;
                array[j + 1] = array[j];
            }
            arrayAccess++;
            array[j + 1] = index;
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

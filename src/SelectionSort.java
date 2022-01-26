/**
 * This Class Sorts an Array with the Selection Sort Algorithm and returns the values to the Interface Algorithm
 * The SelectionSort is not a stable Algorithm
 *
 * @author Philip Jovanovic
 * @version 2.0
 * @since 2021-01-18
 */
public class SelectionSort extends Algorithm {

    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private long time = 0;
    private long storage = 0;
    private long comparisons = 0;
    private long arrayAccess = 0;

    /**
     * This Method sorts the array and changes the position of the values in the array respectively.
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        int number = array.length;

        storage = number * 32 + 5 * 32;
        long start = System.nanoTime();


        for (int i = 0; i < number - 1; i++) {
            int index_minimum = i;
            for (int j = i + 1; j < number; j++) {
                comparisons++;
                if (array[j] < array[index_minimum])
                    index_minimum = j;
            }
            int temp = array[index_minimum];
            arrayAccess += 2;
            array[index_minimum] = array[i];
            array[i] = temp;
        }
        long end = System.nanoTime();
        time = (long) (end - start);

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

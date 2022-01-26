/**
 * This Class Sorts an Array with the Quick Sort Algorithm using the most left value as the pivot
 * and returns the values to the Interface Algorithm.
 * The QuickSort is not a stable Algorithm
 *
 * @author Philip Jovanovic
 * @version 2.0
 * @since 2021-01-18
 */
public class QuickSortLeft extends Algorithm {
    /**
     * Values are defined in order to count them and return them to Algorithm.java
     */
    private long time = 0;
    private long storage = 0;
    private long comparisons = 0;
    private long arrayAccess = 0;


    /**
     * @param array Takes Array from Interface and defines left and right Position. Calls _quickSort Method.
     */
    @Override
    public void sort(int[] array) {

        int n = array.length;
        storage = 32 * (n + 4);
        long start = System.nanoTime();
        _quickSort(array, 0, array.length - 1);
        long end = System.nanoTime();
        time = (long) (end - start);


    }

    /**
     * @param array
     * @param left
     * @param right This Method Sorts the array given in the sort() method. Then it swaps the values in the array and calls itself again.
     *              This is done until the Array is sorted.
     */

    private void _quickSort(int[] array, int left, int right) {


        if (left < right) {
            //Selects the pivot at the most left position in array
            int pivot = array[left];
            int i = left;
            int j = right;
            while (i < j) {
                i += 1;
                // for elements greater than the pivot we selected before
                while (i <= right && array[i] < pivot) {
                    comparisons++;
                    i += 1;
                }
                // finds elements smaller than the pivot we selected before
                while (j >= 1 && array[j] > pivot) {
                    comparisons++;
                    j -= 1;
                }
                //swaps pivot
                if (i <= right && i < j) {
                    swap(array, i, j);
                }
                comparisons += 2;
            }
            //places pivot in the right spot in the array
            swap(array, i, j);
            _quickSort(array, left, j - 1);
            _quickSort(array, j + 1, right);

        }


    }

    /**
     * swaps the numbers at the given values i and j
     *
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {

        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            arrayAccess += 3;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }


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

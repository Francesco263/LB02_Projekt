import java.util.Arrays;
import java.util.Random;

/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class QuickSortRandom extends Algorithm {
    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;


    @Override
    //takes array from Interface Algorithm
    public void sort(int[] array) {
        int n = array.length;
        storage = n * 32 + 5 * 32;
        long start = System.nanoTime();
        _quickSort(array, 0, array.length - 1);
        long end = System.nanoTime();
        time = (int) (end - start);
    }

    // checks if more than 1 item is to be sorted, get new pivot value
    //call quicksort on left and right side
    private void _quickSort(int[] array, int low, int high){
        if (low < high + 1){
            int split = split(array, low, high);
            _quickSort(array, low, split - 1);
            _quickSort(array, split + 1, high);
        }
    }
    //swaps the values given to the numbers, respectably value1 and value2
    private void swapValues(int[] array, int value1, int value2){
        arrayAccess += 3;
        int temp = array[value1];
        array[value1] = array[value2];
        array[value2] = temp;
    }
    //picks a random pivot
    public int pivot(int low, int high){
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }
    //splits the array
    private int split(int[] array, int low, int high){
        swapValues(array, low, pivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++){
            if (array[i] < array[low]){
                comparisons++;
                swapValues(array, i, border++);
            }
        }
        swapValues(array, low, border - 1);
        return border - 1;

    }









    @Override
    public long getTime() {
        return time;
    }

    @Override
    public int getComparison() {
        return comparisons;
    }

    @Override
    public int getArrayAccess() {
        return arrayAccess;
    }

    @Override
    public int getStorage() {
        return storage;
    }
}

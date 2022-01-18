import java.util.Arrays;
import java.util.Random;

/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class QuickSortRandom extends Algorithm {


    @Override
    //takes array from Interface Algorithm
    public void sort(int[] array) {
        _quickSort(array, 0, array.length - 1);
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
                swapValues(array, i, border++);
            }
        }
        swapValues(array, low, border - 1);
        return border - 1;
    }
    //prints the array in sorted condition
    public void printArray(int[] array){
        QuickSortRandom quicksort = new QuickSortRandom();
        //System.out.println(Arrays.toString(array));
        quicksort.sort(array);
        System.out.println(Arrays.toString(array));
    }








    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public int getComparison() {
        return 0;
    }

    @Override
    public int getArrayAccess() {
        return 0;
    }

    @Override
    public int getStorage() {
        return 0;
    }
}

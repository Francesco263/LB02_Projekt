import java.util.Arrays;

/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class QuickSortLeft extends Algorithm {
    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;


    @Override
    public void sort(int[] array) {

        int n = array.length;
        storage = 32 + 4 * 32;
        //Takes Array from Interface and defines left and right Position
        long start = System.nanoTime();
        _quickSort(array, 0, array.length - 1);
        long end = System.nanoTime();
        time = (int) (end - start);


    }
    //Sorts the Array

    private void _quickSort(int[] array, int left, int right){


        if (left < right){
            //Selects the pivot at the most left position in array
            int pivot = array[left];
            int i = left;
            int j = right;
            while (i < j){
                i += 1;
                // for elements greater than the pivot we selected before
                while (i <= right && array[i] < pivot){
                    comparisons++;
                    i += 1;
                }
                // finds elements smaller than the pivot we selected before
                while (j >= 1 && array[j] > pivot){
                    comparisons++;
                    j -= 1;
                }
                //swaps pivot
                if (i <= right && i < j){
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
    //swaps the numbers at the given values i and j
    private void swap(int[] array, int i, int j){

        if (i >= 0 && j >= 0 && i < array.length && j < array.length){
            arrayAccess += 3;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }


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

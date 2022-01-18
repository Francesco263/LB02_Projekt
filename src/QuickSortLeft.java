import java.util.Arrays;

/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class QuickSortLeft extends Algorithm {


    @Override
    public void sort(int[] array) {
        //Takes Array from Interface and defines left and right Position
        _quickSort(array, 0, array.length - 1);
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
                    i += 1;
                }
                // finds elements smaller than the pivot we selected before
                while (j >= 1 && array[j] > pivot){
                    j -= 1;
                }
                //swaps pivot
                if (i <= right && i < j){
                    swap(array, i, j);
                }
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
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    public void printArray(int[] array){
        new QuickSortLeft().sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
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

/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */
public class MergeSort extends Algorithm {
    int left;
    int middle;
    int right;

    //TODO comparisons and array access in mergesort and arrayaccess in bubblesort

    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;


    @Override
    public void sort(int[] array) {
        storage = 32 * array.length * 2 + 7 * 32;
        long start = System.nanoTime();
        int number1 = middle - left + 1;
        int number2 = right - middle;

        int[] Left = new int[number1];
        int[] Right = new int[number2];

        for (int i = 0; i < number1; i++) {
            arrayAccess++;
            Left[i] = array[left + 1];

        }
        for (int j = 0; j < number2; j++) {
            arrayAccess++;
            Right[j] = array[middle + 1 + j];

        }

        int i = 0;
        int j = 0;

        int b = left;
        while (i < number1 && j < number2){
            if (Left[i] <= Right[j]){
                comparisons++;
                array[b] = Left[i];
                arrayAccess++;
                i++;
            }
            else {
                array[b] = Right[j];
                arrayAccess++;
                j++;
            }

            b++;
        }
        while (j < number2){
            array[b] = Right[j];
            arrayAccess++;
            j++;
            b++;
        }

        long end = System.nanoTime();
        time = (int) (end - start);

    }
    public void _sort(int[] array, int left, int right){
        if (left < right){
            middle = left + (right - 1) / 2;
            _sort(array, left, right);
            _sort(array, middle + 1, right);
            sort(array);
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

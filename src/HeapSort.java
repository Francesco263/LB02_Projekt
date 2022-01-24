/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */

public class HeapSort extends Algorithm {

    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;

    /**
     * Method sorts array and switches the values in array
     * @param array is inherited from Algorithm with extends
     */

    public void sort(int array[]) {
        int number = array.length;
        storage = number * 32 + 3 * 32;

        long start = System.nanoTime();


        for (int i = number / 2 - 1; i >= 0; i--)
            heap(array, number, i);


        for (int i = number - 1; i > 0; i--) {

            arrayAccess += 3;
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;


            heap(array, i, 0);
        }
        long end = System.nanoTime();
        time = (int)(end - start);
    }
    void heap(int arr[], int n, int i) {
        int biggest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        storage += 32 * 4;

        comparisons++;
        if (left < n && arr[left] > arr[biggest])
            biggest = left;

        comparisons++;
        if (right < n && arr[right] > arr[biggest])
            biggest = right;

        if (biggest != i) {
            arrayAccess += 3;
            int swap = arr[i];
            arr[i] = arr[biggest];
            arr[biggest] = swap;

            heap(arr, n, biggest);
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

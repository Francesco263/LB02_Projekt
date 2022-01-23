import jdk.internal.org.objectweb.asm.ClassReader;

/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */

public class HeapSort extends Algorithm{
    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;

    @Override
    public void sort(int[] array) {

        int n = array.length;
        storage = n * 32 + 3 * 32;
        long start = System.nanoTime();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            arrayAccess += 3;
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heap(array, i, 0);
        }
        long end = System.nanoTime();
        time = (int)(end - time);

    }
    public void heap(int[] array, int n, int i){
        int biggest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        storage += 32 * 4;

        comparisons++;
        if (left < n && array[left] > array[biggest])
            biggest = left;
        comparisons++;
        if (right < n && array[right] > array[biggest])
            biggest = right;
        if (biggest != i){
            int swap = array[i];
            array[i] = array[biggest];
            array[biggest] = swap;
            heap(array, n, biggest);
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

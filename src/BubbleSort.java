/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */
public class BubbleSort extends Algorithm{

    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private static int arrayAccess = 0;

    @Override
    public void sort(int[] array) {
        int i;
        int j = 0;
        int temp;
        int n = array.length;
        boolean sorted;
        sorted = true;
        storage = n * 32 + 4 * 32 + 8;
        long start = System.nanoTime();

        for (i = 0; i < n-1; i++){
            for (j = 0; j < n-i-1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    sorted = false;
                    arrayAccess += 2;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

        long end = System.nanoTime();
        time = (int) (end - start);

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
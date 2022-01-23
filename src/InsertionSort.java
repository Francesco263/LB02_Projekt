/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */
public class InsertionSort extends Algorithm {

    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;

    @Override
    public void sort(int[] array) {
        storage = 32 + 3 * 32;
        long start = System.nanoTime();

        int lenght = array.length;
        for (int i = 1; i < lenght; i++) {
            int index = array[i];
            arrayAccess++;
            int j = array[i];
            while ((j > -1) && (array[j] > index)){
                array[j + 1] = array[j];
                arrayAccess++;
                j--;
            }
            comparisons += 3;
            array[j + 1] = index;
            arrayAccess++;

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

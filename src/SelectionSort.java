/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class SelectionSort extends Algorithm {
    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private int arrayAccess = 0;

    @Override
    //sorts the array
    public void sort(int[] array) {
        int number = array.length;

        storage = number * 32 + 5 * 32;
        long start = System.nanoTime();


        for (int i = 0; i < number - 1; i++) {
            int index_minimum = i;
            for (int j = i + 1; j < number; j++) {
                comparisons++;
                if (array[j] < array[index_minimum])
                    index_minimum = j;
            }
            int temp = array[index_minimum];
            arrayAccess += 2;
            array[index_minimum] = array[i];
            array[i] = temp;
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

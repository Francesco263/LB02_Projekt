/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class SelectionSort extends Algorithm {
private int time;

    @Override
    //sorts the array
    public void sort(int[] array) {
        long start = System.nanoTime();

        int number = array.length;

        for (int i = 0; i < number - 1; i++) {
            int index_minimum = i;
            for (int j = i + 1; j < number; j++) {
                if (array[j] < array[index_minimum])
                    index_minimum = j;
            }
            int temp = array[index_minimum];
            array[index_minimum] = array[i];
            array[i] = temp;
        }
        long end = System.nanoTime();
        time = (int) (end - start);

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

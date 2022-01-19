/**
 * @author Philip Jovanovic
 * @since 2021-01-18
 * @version 1.0
 */
public class SelectionSort extends Algorithm {


    @Override
    //sorts the array
    public void sort(int[] array) {

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
        printArray(array);

    }

    //Prints the array
    private void printArray(int[] array) {
        int number = array.length;
        for (int i = 0; i < number; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
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

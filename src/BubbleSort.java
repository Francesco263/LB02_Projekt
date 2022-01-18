/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */
public class BubbleSort extends Algorithm{

    private int time;
    private int storage;
    private int comparisons;
    private int arrayAccess;

    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        long end = System.nanoTime();
                time = (int) (end - start);
        printArray(array);

    }
    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        //System.out.println(time /  1_000_000_000.0 + " seconds");
    }

    @Override
    public long getTime() {
        return time;
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
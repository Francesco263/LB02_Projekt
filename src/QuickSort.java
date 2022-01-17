
import java.util.*;

class QuickSort extends Algorithm{

    static int partition(int arr[], int low, int high) {
       sort(arr, low, high);
        int pivot = arr[high];


        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    static void _sort(int arr[], int low, int high) {
        if (low < high) {


            int pi = partition(arr, low, high);


            _sort(arr, low, pi - 1);
            _sort(arr, pi + 1, high);
        }
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    @Override
    public void sort(int[] array) {

        int high = 0;
        int low = 0;
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int index1 = array[pivot];
        array[pivot] = array[high];
        array[high] = index1;
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
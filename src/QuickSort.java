import java.util.*;
/**
 * @author XX
 * @since 2021-01-XX
 * @version 1.0
 */
class QuickSort {
    static void sort(int arr[], int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int index1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = index1;
    }

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
}

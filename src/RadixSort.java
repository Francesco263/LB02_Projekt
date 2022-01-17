import javax.naming.PartialResultException;
import java.util.*;
/**
 * @author Philip Jovanovic
 * @since 2021-01-17
 * @version 1.0
 */
public class RadixSort extends Algorithm {
    private static int getMaximum(int arr[], int n) {
        return 0;
    }

    //Philip du Schwanz implementier das bitte richtig da une, danke.
    //Machi gu Gay

    @Override
    public void sort(int[] array) {

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }

    public void count(int[] array, int lenght, int b) {
        int[] result = new int[lenght];
        int i;
        int[] count = new int[lenght];

        for (i = 0; i < lenght; i++)
            count[(array[i] / b) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = lenght - 1; i >= 0; i--) {
            result[count[(array[i] / b) % 10] - 1] = array[i];
            count[(array[i] / b) % 10]--;
        }
        for (i = 0; i < lenght; i++) {
            array[i] = result[i];
        }
    }

    public void partition(int[] array, int lenght) {
        int m = sort(array, lenght);
        for (int b = 1; m / b > 0; b *= 10)
            count(array, lenght, b);
    }
    public void printarray(int array[]){
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    private int sort(int[] array, int lenght) {
        return 0;
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


    /*

    static int get_max_val(int[] array, int lenght) {
        int max_val = array[0];
        for (int i = 1; i < lenght; i++)
            if (array[i] > max_val)
                max_val = array[i];
        return max_val;
    }
    static void countSort(int[] array, int lenght, int b) {
        int[] result = new int[lenght];
        int i;
        int[] count = new int[10];
        Arrays.fill(count,0);
        for (i = 0; i < lenght; i++)
            count[ (array[i]/b)%10 ]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = lenght - 1; i >= 0; i--) {
            result[count[ (array[i]/b)%10 ] - 1] = array[i];
            count[ (array[i]/b)%10 ]--;
        }
        for (i = 0; i < lenght; i++)
            array[i] = result[i];
    }
    static void radix_sort(int[] array, int lenght) {
        int m = get_max_val(array, lenght);
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(array, lenght, exp);
    }
    public static void main (String[] args) {
        int[] array = {56, 78, 102, 345, 67, 90, 102, 45, 78};
        int arr_len = array.length;
        System.out.println("The array after performing radix sort is ");
        radix_sort(array, arr_len);
        for (int j : array) System.out.print(j + " ");
    }

     */
}

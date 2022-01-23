public class MergeSort extends Algorithm {
    int left;
    int middle;
    int right;


    @Override
    public void sort(int[] array) {
        int number1 = middle - left + 1;
        int number2 = right - middle;

        int[] Left = new int[number1];
        int[] Right = new int[number2];

        for (int i = 0; i < number1; i++) {
            Left[i] = array[left + 1];
        }
        for (int j = 0; j < number2; j++) {
            Right[j] = array[middle + 1 + j];
        }

        int i = 0;
        int j = 0;

        int b = left;
        while (i < number1 && j < number2){
            if (Left[i] <= Right[j]){
                array[b] = Left[i];
                i++;
            }
            else {
                array[b] = Right[j];
                j++;
            }
            b++;
        }
        while (j < number2){
            array[b] = Right[j];
            j++;
            b++;
        }



    }
    public void _sort(int[] array, int left, int right){
        if (left < right){
            middle = left + (right - 1) / 2;
            _sort(array, left, right);
            _sort(array, middle + 1, right);
            sort(array);
        }
    }
    public static void printArray(int[] array){
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.println(array[i] + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6 ,7};
        System.out.println("Given Array; ");
        printArray(array);

        MergeSort ob = new MergeSort();
        ob._sort(array, 0, array.length - 1);

        System.out.println("\n Sorted Array");
        printArray(array);
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

public class CocktailSort extends Algorithm {

    private int time = 0;
    private int storage = 0;
    private int comparisons = 0;
    private static int arrayAccess = 0;


    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        storage = 32 * 2 + 32 + 8;
        boolean swap = true;
        int beginning = 0;
        int end = array.length;

        while (swap == true){
            swap = false;
            for (int i = beginning; i < end - 1; i++) {
                comparisons++;
                if (array[i] > array[i + 1]){
                    arrayAccess += 3;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false)
                break;
            swap = false;

            end = end - 1;

            for (int i = end - 1; i >= beginning; i--) {
                comparisons++;
                if (array[i] > array[i + 1]){
                    arrayAccess += 3;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            beginning = beginning + 1;
        }
        long endTime = System.nanoTime();
        time = (int)(endTime - startTime);

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


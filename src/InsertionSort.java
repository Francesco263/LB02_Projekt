public class InsertionSort extends Algorithm {

    private int time;

    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        int lenght = array.length;
        for (int i = 1; i < lenght; i++) {
            int index = array[i];
            int j = array[i];
            while ((j > -1) && (array[j] > index)){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = index;

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

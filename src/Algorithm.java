/**
 * @author Francesco Feroldi
 * @since 2021-01-24
 * @version 1.0
 */
public abstract class Algorithm {
    public abstract void sort(int[] array);
    public abstract long getTime();
    public abstract int getComparison();
    public abstract int getArrayAccess();
    public abstract int getStorage();
}

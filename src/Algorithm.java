/**
 * @author Francesco Feroldi
 * @version 1.0
 * @since 2021-01-24
 */
public abstract class Algorithm {
    public abstract void sort(int[] array);

    public abstract long getTime();

    public abstract long getComparison();

    public abstract long getArrayAccess();

    public abstract long getStorage();
}

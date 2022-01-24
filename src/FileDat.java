/**
 * @author Francesco Feroldi
 * @since 2021-01-24
 * @version 1.0
 */
public class FileDat {
    private String fileName;
    private int fileSize;

    public FileDat(String fileName, int fileSize){
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    
    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }
}

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

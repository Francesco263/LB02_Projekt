public class FileDat {

    private char fileToken;
    private String fileName;
    private int fileSize;

    public FileDat(char fileToken, String fileName, int fileSize){
        this.fileToken = fileToken;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public char getFileToken() {
        return fileToken;
    }

    public void setFileToken(char fileToken) {
        this.fileToken = fileToken;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
}

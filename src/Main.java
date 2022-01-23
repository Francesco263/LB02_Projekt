import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Main {
    Einleser einleser;
    public Main(){
        einleser = new Einleser();
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Main program = new Main();
        program.run();
    }
    private void run() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Greetings();
    }
    public void Greetings() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        System.out.println("Welcome to our sorting program v.3.3.");
        System.out.println("_____________________________________");
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ClearCmd();
        chooseRunMethod();
    }
    public void ClearCmd(){
        for (int i = 0; i < 50; i++){
            System.out.println("");
        }
    }
    public void chooseRunMethod() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        char runMethodSelection = ' ';
        System.out.println("Choose an option:\n");
        while (runMethodSelection == ' '){
            System.out.println("Press A - run everything");
            System.out.println("Press B - choose algorithm");
            runMethodSelection = einleser.readChar("> ", new char[]{'a','b'});
        }
        ClearCmd();
        prepareArrayFileNames(runMethodSelection);
    }
    public void prepareArrayFileNames(char runMethodSelection) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        String[] blacklist = new String[]{"Algorithm.java", "ArrayDat.java", "Einleser.java", "FileDat.java", "Main.java"};
        File folder = new File("LB02_Projekt/src");
        File[] files = folder.listFiles();
        Vector<String> arrayNames = new Vector();
        boolean blacklistFound;
        for (int i = 0; i < files.length; i++){
            blacklistFound = false;
            for (int y = 0; y < blacklist.length; y++){
                if (files[i].getName().equals(blacklist[y])){
                    blacklistFound = true;
                }
            }
            if (!blacklistFound && arrayNames.size() <= 26){
                arrayNames.add(files[i].getName().substring(0, files[i].getName().length() - 5));
            }
        }
        if (runMethodSelection == 'a'){
            initialize(1,0,arrayNames);
        }
        else{
            chooseAlgorithm(arrayNames);
        }
    }
    public void chooseAlgorithm(Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        char algorithmSelection = ' ';
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] selection = new char[arrayNames.size()];
        for (int i = 0; i < arrayNames.size(); i++){
            selection[i] = Character.toLowerCase(alphabet[i]);
        }
        while (algorithmSelection == ' '){
            System.out.println("Available algorithms:\n");
            for (int i = 0; i < arrayNames.size(); i++){
                System.out.println("Press " + Character.toUpperCase(selection[i]) + " - " + arrayNames.get(i));
            }
            algorithmSelection = einleser.readChar("> ", selection);
        }
        System.out.println("Please wait while the program is calculating...");
        for (int i = 0; i < selection.length; i++){
            if (algorithmSelection == selection[i]){
                initialize(2,(i+1), arrayNames);
            }
        }
    }
    public void initialize(int option, int choose, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        FileDat[] fileDats = new FileDat[9];
        String[] filenames = new String[]{"InversTeilsortiert1000.dat","InversTeilsortiert10000.dat","InversTeilsortiert100000.dat","Random1000.dat","Random10000.dat","Random100000.dat","Teilsortiert1000.dat","Teilsortiert10000.dat","Teilsortiert100000.dat"};
        int[] sizes = new int[]{1000,10000,100000,1000,10000,100000,1000,10000,100000};
        for (int i = 0; i < 9; i++){
            fileDats[i] = new FileDat(filenames[i],sizes[i]);
        }
        createArray(option, choose, fileDats, arrayNames);
    }
    public void createArray(int option, int choose, FileDat[] fileDats, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        ArrayDat[] arrays = new ArrayDat[9];
        for (int i = 0; i < 9; i++){
            ArrayDat array = new ArrayDat(arrayFiller(fileDats[i].getFileName(), fileDats[i].getFileSize()));
            arrays[i] = array;
        }
        sortInitializer(option, choose, arrays, arrayNames);
    }
    public int[] arrayFiller(String filename, int filesize){
        int cntr = 0;
        int[] array = new int[filesize];
        BufferedReader br = null;
        try {
            File file = new File("LB02_Projekt/files/" + filename);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                array[cntr++] = Integer.parseInt(line);
            }
        }
        catch(IOException e) { e.printStackTrace();}
        finally {
            try { if (br != null) br.close(); }
            catch(IOException e) { e.printStackTrace(); }
        }
        return array;
    }
    public void sortInitializer(int option, int choose, ArrayDat[] arrays, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Algorithm[] algorithms = new Algorithm[arrayNames.size()];
        createAlgorithms(algorithms, arrayNames);
        if (option == 1){
            sortMain(0,algorithms.length,arrays, algorithms, arrayNames);
        }
        else{
            sortMain((choose - 1),choose,arrays, algorithms, arrayNames);
        }
    }
    public void sortMain(int f, int valueF, ArrayDat[] arrays, Algorithm[] algorithms, Vector<String> arrayNames) throws IOException {
        String[] filenamesA = new String[]{"InversTeilsortiert1000.dat","InversTeilsortiert10000.dat","InversTeilsortiert100000.dat","Random1000.dat","Random10000.dat","Random100000.dat","Teilsortiert1000.dat","Teilsortiert10000.dat","Teilsortiert100000.dat"};
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (int y = 0; y < 9; y++){
            int u = 0;
            XSSFSheet sheet = workbook.createSheet(filenamesA[y]);
            XSSFRow row = sheet.createRow(0);
            row.createCell(1).setCellValue("Zeit");
            row.createCell(2).setCellValue("Speicher");
            row.createCell(3).setCellValue("Zugriffe");
            row.createCell(4).setCellValue("Vergleiche");
            for (int i = f; i < valueF; i++){
                int[] tempArray = arrays[y].getArray();
                algorithms[i].sort(tempArray);
                XSSFRow row1 = sheet.createRow(u+1);
                row1.createCell(0).setCellValue(arrayNames.get(i));
                row1.createCell(1).setCellValue(algorithms[i].getTime());
                row1.createCell(2).setCellValue(algorithms[i].getStorage());
                row1.createCell(3).setCellValue(algorithms[i].getArrayAccess());
                row1.createCell(4).setCellValue(algorithms[i].getComparison());
                u++;
            }
        }
        FileOutputStream excelOutput = new FileOutputStream("LB02_Projekt/output/excel_output.xlsx");
        workbook.write(excelOutput);
    }
    public Algorithm[] createAlgorithms(Algorithm[] algorithms, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < arrayNames.size(); i++){
            algorithms[i] = createAlgorithmFromString(arrayNames.get(i));
        }
        return algorithms;
    }
    public Algorithm createAlgorithmFromString(String name) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class c= Class.forName(name);
        return (Algorithm) c.getDeclaredConstructor().newInstance();
    }
}

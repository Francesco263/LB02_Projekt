import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Main Methode (Kul) - LB02 Projekt
 * @author Francesco Feroldi
 * @since 2021-01-24
 * @version 3.3
 */
public class Main {
    Einleser einleser;
    public Main(){
        einleser = new Einleser();
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Main program = new Main();
        program.run();
    }
    /**
     * This is the run-method, calls Greetings() to start the program
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    private void run() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Greetings();
    }
    /**
     * Greetings() Method is used to welcome the user
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
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
    /**
     * ClearCmd() clears the cmd
     */
    public void ClearCmd(){
        for (int i = 0; i < 50; i++){
            System.out.println("");
        }
    }
    /**
     * This method is used to ask the user if he wants to run everything or choose an algorithm. The output value
     * will be given with the method prepareArrayFiller.
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
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
    /**
     * This method is used to scan the directory for available algorithms and save them without ".java" in algorithmNames Vector.
     * Before filling the Vector, the filename will be compared with the blacklist array, so the other program methods can not
     * cause any problems.
     * If the user clicked on choose algorithm, the Vector and choose option will be sent to chooseAlgorithm(). Else, the chooseAlgorithm()
     * method will be skipped. initialize() will be called instead.
     * Based on what the user clicks, option and choose will be initialized. They will be used at the end of the program to
     * know what to sort.
     * @param runMethodSelection
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void prepareArrayFileNames(char runMethodSelection) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        String[] blacklist = new String[]{"Algorithm.java", "ArrayDat.java", "Einleser.java", "FileDat.java", "Main.java"};
        File folder = new File("LB02_Projekt/src");
        File[] files = folder.listFiles();
        Vector<String> algorithmNames = new Vector();
        boolean blacklistFound;
        for (int i = 0; i < files.length; i++){
            blacklistFound = false;
            for (int y = 0; y < blacklist.length; y++){
                if (files[i].getName().equals(blacklist[y])){
                    blacklistFound = true;
                }
            }
            if (!blacklistFound && algorithmNames.size() <= 26){
                algorithmNames.add(files[i].getName().substring(0, files[i].getName().length() - 5));
            }
        }
        if (runMethodSelection == 'a'){
            initialize(1,0,algorithmNames);
        }
        else{
            chooseAlgorithm(algorithmNames);
        }
    }
    /**
     * If the user wishes to select a single algorithm, this method will be called. Dependent on the amount of algorithms found,
     * this method creates a list for the user, in which he can choose between the available algorithms. After the user selected
     * an algorithm, initialize() will be called.
     * @param algorithmNames
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void chooseAlgorithm(Vector<String> algorithmNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        char algorithmSelection = ' ';
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] selection = new char[algorithmNames.size()];
        for (int i = 0; i < algorithmNames.size(); i++){
            selection[i] = Character.toLowerCase(alphabet[i]);
        }
        while (algorithmSelection == ' '){
            System.out.println("Available algorithms:\n");
            for (int i = 0; i < algorithmNames.size(); i++){
                System.out.println("Press " + Character.toUpperCase(selection[i]) + " - " + algorithmNames.get(i));
            }
            algorithmSelection = einleser.readChar("> ", selection);
        }
        System.out.println("Please wait while the program is calculating...");
        for (int i = 0; i < selection.length; i++){
            if (algorithmSelection == selection[i]){
                initialize(2,(i+1), algorithmNames);
            }
        }
    }
    /**
     * This method initializes the files which will be sorted. fileDat is an object containing fileSize and fileName.
     * An array of fileDat is created with 9 fileDat in it, for the 9 files in the directory.
     * @param option
     * @param choose
     * @param algorithmNames
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void initialize(int option, int choose, Vector<String> algorithmNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        FileDat[] fileDats = new FileDat[9];
        String[] filenames = new String[]{"InversTeilsortiert1000.dat","InversTeilsortiert10000.dat","InversTeilsortiert100000.dat","Random1000.dat","Random10000.dat","Random100000.dat","Teilsortiert1000.dat","Teilsortiert10000.dat","Teilsortiert100000.dat"};
        int[] sizes = new int[]{1000,10000,100000,1000,10000,100000,1000,10000,100000};
        for (int i = 0; i < 9; i++){
            fileDats[i] = new FileDat(filenames[i],sizes[i]);
        }
        createArray(option, choose, fileDats, algorithmNames, filenames);
    }
    /**
     * createArray() creates an array of arrays with the help of the object ArrayDat (containing String[]). This method creates an array for
     * each file and fills it with the right values using arrayFiller() method. The end result is an array with 9 arrays in it,
     * containing the values of 9 files.
     * @param option
     * @param choose
     * @param fileDats
     * @param algorithmNames
     * @param filenames
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void createArray(int option, int choose, FileDat[] fileDats, Vector<String> algorithmNames, String[] filenames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        ArrayDat[] arrays = new ArrayDat[9];
        for (int i = 0; i < 9; i++){
            ArrayDat array = new ArrayDat(arrayFiller(fileDats[i].getFileName(), fileDats[i].getFileSize()));
            arrays[i] = array;
        }
        sortInitializer(option, choose, arrays, algorithmNames, filenames);
    }
    /**
     * arrayFiller() scans each line in a file. It knows which file to scan due to the filename given. It creates an array
     * based on the given filesize and fills it with the lines of the files as an int.
     * @param filename
     * @param filesize
     * @return
     */
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
    /**
     * createArray() method will call sortInitializer(). It gives option and choose to later determine what the user clicked on.
     * ArrayDat arrays is an array filled with all values of all files. algorithmNames is a Vector filled with the scanned algorithms
     * in the source root. filenames will be given to later name the excel sheets.
     * Based on the algorithms found and the Vector with names, sortInitializer() creates an array of algorithm objects, using the
     * method createAlgorithms(). Then it validates the user input of before and based on that sends to sortMain what is needed
     * to sort the right algorithms.
     * @param option
     * @param choose
     * @param arrays
     * @param algorithmNames
     * @param filenames
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void sortInitializer(int option, int choose, ArrayDat[] arrays, Vector<String> algorithmNames, String[] filenames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Algorithm[] algorithms = new Algorithm[algorithmNames.size()];
        createAlgorithms(algorithms, algorithmNames);
        if (option == 1){
            sortMain(0,algorithms.length,arrays, algorithms, algorithmNames, filenames);
        }
        else{
            sortMain((choose - 1),choose,arrays, algorithms, algorithmNames, filenames);
        }
    }
    /**
     * sortMain is used to call sort() function on algorithm objects in array algorithms between f and valueF. If the user choosed
     * a specific, f starts at choose-1 and there is only one iteration. If the user clicked on runEverything, f is 0 and valueF the
     * amount of algorithms found. It then creates an Excel file and writes all return values from the algorithms in it.
     * @param f
     * @param valueF
     * @param arrays
     * @param algorithms
     * @param algorithmNames
     * @param filenames
     * @throws IOException
     */
    public void sortMain(int f, int valueF, ArrayDat[] arrays, Algorithm[] algorithms, Vector<String> algorithmNames, String[] filenames) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (int y = 0; y < 9; y++){
            int u = 0;
            XSSFSheet sheet = workbook.createSheet(filenames[y]);
            XSSFRow row = sheet.createRow(0);
            row.createCell(1).setCellValue("Zeit");
            row.createCell(2).setCellValue("Speicher");
            row.createCell(3).setCellValue("Zugriffe");
            row.createCell(4).setCellValue("Vergleiche");
            for (int i = f; i < valueF; i++){
                int[] tempArray = arrays[y].getArray();
                algorithms[i].sort(tempArray);
                XSSFRow row1 = sheet.createRow(u+1);
                row1.createCell(0).setCellValue(algorithmNames.get(i));
                row1.createCell(1).setCellValue(algorithms[i].getTime());
                row1.createCell(2).setCellValue(algorithms[i].getStorage());
                row1.createCell(3).setCellValue(algorithms[i].getArrayAccess());
                row1.createCell(4).setCellValue(algorithms[i].getComparison());
                u++;
            }
        }
        FileOutputStream excelOutput = new FileOutputStream("LB02_Projekt/output/excel_output.xlsx");
        workbook.write(excelOutput);
        ClearCmd();
        System.out.println("Successfully finished. Output-file can be found in LB02_Projekt/output");
    }
    /**
     * createAlgorithms() is used to iterate in algorithmNames and call the method createAlgorithmFromString(). It then
     * fills the array of algorithm objects with the return value of createAlgorithmFromString().
     * @param algorithms
     * @param algorithmNames
     * @return
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Algorithm[] createAlgorithms(Algorithm[] algorithms, Vector<String> algorithmNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < algorithmNames.size(); i++){
            algorithms[i] = createAlgorithmFromString(algorithmNames.get(i));
        }
        return algorithms;
    }
    /**
     * This method creates an instance of an algorithm based on a given string.
     * @param name
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public Algorithm createAlgorithmFromString(String name) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class c= Class.forName(name);
        return (Algorithm) c.getDeclaredConstructor().newInstance();
    }
}

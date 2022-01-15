import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import java.awt.*;
import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Vector;

public class Main {
    Einleser einleser;
    public Main(){
        einleser = new Einleser();
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Main program = new Main();
        program.run();
    }
    private void run() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Greetings();
    }
    public void Greetings() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Welcome to our sorting program v.3.2.");
        System.out.println("_____________________________________");
        LoadingScreen();
        ClearCmd();
        chooseRunMethod();
    }
    public void ClearCmd(){
        for (int i = 0; i < 50; i++){
            System.out.println("");
        }
    }
    public void LoadingScreen(){
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void chooseRunMethod() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        char runMethodSelection = ' ';
        while (runMethodSelection == ' '){
            System.out.println("Press A - run everything");
            System.out.println("Press B - choose algorithm");
            runMethodSelection = einleser.readChar("> ", new char[]{'a','b'});
        }
        ClearCmd();
        prepareArrayFileNames(runMethodSelection);
    }
    public void prepareArrayFileNames(char runMethodSelection) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
    public void chooseAlgorithm(Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        char algorithmSelection = ' ';
        char[] alphabet = new char[]{'A','B','C','D','E','F','G','H','I','J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] selection = new char[arrayNames.size()];
        for (int i = 0; i < arrayNames.size(); i++){
            selection[i] = Character.toLowerCase(alphabet[i]);
        }
        while (algorithmSelection == ' '){
            for (int i = 0; i < arrayNames.size(); i++){
                System.out.println("Press " + Character.toUpperCase(selection[i]) + " - " + arrayNames.get(i));
            }
            algorithmSelection = einleser.readChar("> ", selection);
        }
        System.out.println("Please wait while the program is calculating...");
        LoadingScreen();
        for (int i = 0; i < selection.length; i++){
            if (algorithmSelection == selection[i]){
                initialize(2,(i+1), arrayNames);
            }
        }
    }
    public void initialize(int option, int choose, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileDat[] fileDats = new FileDat[9];
        String[] filenames = new String[]{"InversTeilsortiert1000.dat","InversTeilsortiert10000.dat","InversTeilsortiert100000.dat","Random1000.dat","Random10000.dat","Random100000.dat","Teilsortiert1000.dat","Teilsortiert10000.dat","Teilsortiert100000.dat"};
        int[] sizes = new int[]{1000,10000,100000,1000,10000,100000,1000,10000,100000};
        for (int i = 0; i < 9; i++){
            fileDats[i] = new FileDat(filenames[i],sizes[i]);
        }
        createArray(option, choose, fileDats, arrayNames);
    }
    public void createArray(int option, int choose, FileDat[] fileDats, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
    public void sortInitializer(int option, int choose, ArrayDat[] arrays, Vector<String> arrayNames) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Algorithm[] algorithms = new Algorithm[arrayNames.size()];
        createAlgorithms(algorithms, arrayNames);
        if (option == 1){
            sortMain(0,algorithms.length,arrays, algorithms);
        }
        else{
            sortMain((choose - 1),choose,arrays, algorithms);
        }
    }
    public void sortMain(int f, int valueF, ArrayDat[] arrays, Algorithm[] algorithms){
        for (int i = f; i < valueF; i++){
            for (int y = 0; y < 9; y++){
                algorithms[i].sort(arrays[y].getArray());
                createExcel(algorithms[i].getTime(), algorithms[i].getComparison(), algorithms[i].getArrayAccess(), algorithms[i].getStorage());
            }
        }
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
    public <Workbook> void createExcel(long time, int comparison, int arrayAccess, int storage){
        //Hier wird Excel generiert - Chris vill spass
    }
}

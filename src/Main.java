import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    Einleser einleser;

    public Main(){
        einleser = new Einleser();
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    private void run() {
        Greetings();
    }

    public void Greetings(){
        System.out.println("Welcome to our sorting program v.2.1.");
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
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseRunMethod(){
        char runMethodSelection = ' ';
        while (runMethodSelection == ' '){
            System.out.println("Press A - run everything");
            System.out.println("Press B - choose algorithm");
            runMethodSelection = einleser.readChar("> ", new char[]{'a','b'});
        }
        ClearCmd();
        if (runMethodSelection == 'a'){
            initialize(1,0);
            System.out.println("Please wait while the program is calculating...");
        }
        else if (runMethodSelection == 'b'){
            chooseAlgorithm();
        }
    }

    public void chooseAlgorithm(){
        char algorithmSelection = ' ';
        while (algorithmSelection == ' '){
            System.out.println("Press A - QuickSort");
            System.out.println("Press B - RadixSort");
            System.out.println("Press C - .........");
            algorithmSelection = einleser.readChar("> ", new char[]{'a','b', 'c'});
        }
        System.out.println("Please wait while the program is calculating...");
        LoadingScreen();
        if (algorithmSelection == 'a'){
            initialize(2,1);
        }
        else if (algorithmSelection == 'b'){
            initialize(2,2);
        }
        else{
            initialize(2,3);
        }
    }

    public void initialize(int option, int choose){
        FileDat[] fileDats = new FileDat[9];
        fileDats[0] = new FileDat("InversTeilsortiert1000.dat", 1000);
        fileDats[1] = new FileDat("InversTeilsortiert10000.dat", 10000);
        fileDats[2] = new FileDat("InversTeilsortiert100000.dat", 100000);
        fileDats[3] = new FileDat("Random1000.dat", 1000);
        fileDats[4] = new FileDat("Random10000.dat", 10000);
        fileDats[5] = new FileDat("Random100000.dat", 100000);
        fileDats[6] = new FileDat("Teilsortiert1000.dat", 1000);
        fileDats[7] = new FileDat("Teilsortiert10000.dat", 10000);
        fileDats[8] = new FileDat("Teilsortiert100000.dat", 100000);
        createArray(option, choose, fileDats);
    }

    public void createArray(int option, int choose, FileDat[] fileDats){
        ArrayDat[] arrays = new ArrayDat[9];
        for (int i = 0; i < 9; i++){
            ArrayDat array = new ArrayDat(arrayFiller(fileDats[i].getFileName(), fileDats[i].getFileSize()));
            arrays[i] = array;
        }
        sortInitialize(option, choose, arrays);
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
                array[cntr] = Integer.parseInt(line);
                cntr++;
            }
        }
        catch(IOException e) { e.printStackTrace();}
        finally
        {
            try { if (br != null) br.close(); }
            catch(IOException e) { e.printStackTrace(); }
        }
        return array;
    }

    public void sortInitialize(int option, int choose, ArrayDat[] arrays){
        Algorithm[] algorithms = new Algorithm[2];
        algorithms[0] = new QuickSort();
        if (option == 1){
            sortMain(0,algorithms.length,arrays, algorithms);
        }
        else{
            if (choose == 1){
                sortMain(0,1,arrays, algorithms);
            }
            else if (choose == 2){
                sortMain(1,2,arrays, algorithms);
            }
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

    public void createExcel(long time, int comparison, int arrayAccess, int storage){
        //Create Excel here.
    }
}

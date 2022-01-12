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
        System.out.println("Welcome to our sorting program v.1.0.");
        chooseFile();
    }

    public void chooseFile(){

        char fileChoice = ' ';

        System.out.println("Choose a file which will be sorted.");

        while (fileChoice == ' '){

            System.out.println("Press A - InvertedPartialSorted (1000)");
            System.out.println("Press B - InvertedPartialSorted (10000)");
            System.out.println("Press C - InvertedPartialSorted (100000)");
            System.out.println("Press D - Random (1000)");
            System.out.println("Press E - Random (10000)");
            System.out.println("Press F - Random (100000)");
            System.out.println("Press G - PartialSorted (1000)");
            System.out.println("Press H - PartialSorted (10000)");
            System.out.println("Press I - PartialSorted (100000)");
            fileChoice = einleser.readChar("> ", new char[]{'a','b','c','d', 'e', 'f', 'g', 'h', 'i'});
            fileChoice = Character.toUpperCase(fileChoice);

        }

        Initialize(fileChoice);

    }

    public void Initialize(char choice2){

        String fileName = "";
        int fileSize = 0;
        FileDat[] fileDats = new FileDat[8];

        FileDat file1 = new FileDat('A', "InversTeilsortiert1000.dat", 1000);
        FileDat file2 = new FileDat('B', "InversTeilsortiert10000.dat", 10000);
        FileDat file3 = new FileDat('C', "InversTeilsortiert100000.dat", 100000);
        FileDat file4 = new FileDat('D', "Random1000.dat", 1000);
        FileDat file5 = new FileDat('E', "Random10000.dat", 10000);
        FileDat file6 = new FileDat('F', "Random100000.dat", 100000);
        FileDat file7 = new FileDat('G', "Teilsortiert1000.dat", 1000);
        FileDat file8 = new FileDat('H', "Teilsortiert10000.dat", 10000);
        FileDat file9 = new FileDat('I', "Teilsortiert100000.dat", 100000);

        for (int i = 0; i < 9; i++){
            if (choice2 == fileDats[i].getFileToken()){
                fileName = fileDats[i].getFileName();
                fileSize = fileDats[i].getFileSize();
            }
        }

        fillArray(fileName, fileSize);
    }

    public void fillArray(String filename, int fileSize){

        int[] array = new int[fileSize];
        int cntr = 0;

        BufferedReader br = null;
        try {
            File file = new File("files\\" + filename); // java.io.File
            FileReader fr = new FileReader(file); // java.io.FileReader
            br = new BufferedReader(fr); // java.io.BufferedReader
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

        ChooseAlgorithm(array);
    }

    public void ChooseAlgorithm(int[] arrayToSort){
        char algorithmChoice = ' ';

        System.out.println("Choose what algorithm which will be use to sort.");

        while (algorithmChoice == ' '){

            System.out.println("Press A - BubbleSort");
            System.out.println("Press B - QuickSort");
            System.out.println("Press C - SelectionSort");
            algorithmChoice = einleser.readChar("> ", new char[]{'a','b','c'});
            algorithmChoice = Character.toUpperCase(algorithmChoice);



        }
    }


}

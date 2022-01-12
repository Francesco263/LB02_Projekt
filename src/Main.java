import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Wilkommen bei unserem Algorithmus-Vergleich");

        Double[] array = new Double[1000];
        int cntr = 0;

        for(int i = 0; i < 1000; i++){
            System.out.println(array[i]);
        }

    }

    public String[] datenEinleser(String[] array, int cntr){
        BufferedReader br = null;
        try {
            File file = new File("files\\InversTeilsortiert1000.dat"); // java.io.File
            FileReader fr = new FileReader(file); // java.io.FileReader
            br = new BufferedReader(fr); // java.io.BufferedReader
            String line;
            while ((line = br.readLine()) != null) {
                array[cntr] = line;
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
}

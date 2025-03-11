package at.fhj.msd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        
        String filename = "src\\main\\resources\\data.txt";
        ArrayList<String> listOfSchedules = read(filename);
        


    }

    public static ArrayList<String> read(String filename) {

        File file = new File(filename);

        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
               lines.add(line);
            }
        }catch (IOException e) {
            System.out.printf("Error during reading the file '%s'", file);
            return null;
        }
        return lines;
    }


}

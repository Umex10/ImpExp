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
        String delimeter = ";";
        ArrayList<Schedule> ValidLines = readData(listOfSchedules, delimeter);

        //?Test for method .asCsv()
       Schedule obj = new Schedule("SWD", "G1", "Software Development II", "2024-02-23 14:00:00", "024-02-23 16:15:00", "Harald Schwab", "Hörsaal (ITM) (WS46b.01.103)");
       // System.out.println(obj.asCsv(":"));  
       System.out.println(obj.asSql());
        

    }

    //! Reads data from a textfile, and returns a list.

    public static ArrayList<String> read(String filename) {

        File file = new File(filename);

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.printf("Error during reading the file '%s'", file);
            return null;
        }
        return lines;
    }

    public static ArrayList<Schedule> readData(ArrayList<String> lines, String delimeter) {
        int countLines = 0;
        ArrayList<Schedule> ValidLines = new ArrayList<>(); //This list will contain all "valid" objects

        try {

            for (String line : lines) {
                try {
                    String[] teile = line.split(delimeter); //This breaks each line into words which specified delimeter
                    countLines++;
                    Schedule row = new Schedule(teile[0], teile[2], teile[1], teile[3], teile[4], teile[7], teile[5]); //Choosed necassary columns
                    ValidLines.add(row); 

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " --> on " + countLines);

                } catch (Exception e) {
                    System.out.println("Error");

                }
            }
        } catch (Exception e) {

            System.out.println("Error");

        }
        return ValidLines;

    }

}

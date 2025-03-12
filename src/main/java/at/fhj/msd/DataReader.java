package at.fhj.msd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    private String filename;

    public DataReader(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> read() {

        File file = new File(this.filename);

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("file '%s' was not found: ", file);

        } catch (IOException e) {
            System.out.printf("Error during reading the file '%s'", file);
            return null;
        }
        return lines;
    }

    public ArrayList<Schedule> readData(ArrayList<String> lines, String delimeter) {
        int countLines = 0;
        ArrayList<Schedule> ValidLines = new ArrayList<>(); //This list will contain all "valid" objects

        try {

            for (String line : lines) {
                try {
                    String[] teile = line.split(delimeter); //This breaks each line into words which specified delimeter
                    countLines++;
                    Schedule row = new Schedule(teile[0], teile[2], teile[1], teile[3], teile[4], teile[7], teile[5]); //choose necassary columns
                    ValidLines.add(row);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " --> on " + countLines);

                } catch (Exception e) {
                    System.out.println("Somewhere error" + e.getMessage());
                }
            }
        } catch (Exception e) {

            System.out.println("Somewhere error" + e.getMessage());

        }
        return ValidLines;

    }

}

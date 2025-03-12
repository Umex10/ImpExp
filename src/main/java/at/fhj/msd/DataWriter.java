package at.fhj.msd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataWriter {

    public DataWriter() {

    }

    public void writeCsv(ArrayList<Schedule> ValidLines) {

        int countLines = 0;

        //? Lines with comma
        File file = new File("src/main/resources/data.csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            for (Schedule line : ValidLines) {
                bw.write(line.asCsv(",") + "\n");
                countLines++;
            }
            System.out.printf("Filename: '%s' | Lines written: %d", file, countLines);

        } catch (IOException e) {
            System.out.println("Somewhere error");
        }

    }

    public void writeTsv(ArrayList<Schedule> ValidLines) {

        int countLines = 0;

        File file = new File("src/main/resources/data1.tsv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            for (Schedule line : ValidLines) {
                bw.write(line.asCsv("    ") + "\n");
                countLines++;
            }
            System.out.printf("Filename: '%s' | Lines written: %d", file, countLines);

        } catch (IOException e) {
            System.out.println("Somewhere error");
        }
    }

    public void writeSql(ArrayList<Schedule> ValidLines) {

        int countLines = 0;

        File file = new File("src/main/resources/data1.sql");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            for (Schedule line : ValidLines) {
                bw.write(line.asSql() + "\n");
                countLines++;
            }
            System.out.printf("Filename: '%s' | Lines written: %d", file, countLines);

        } catch (IOException e) {
            System.out.println("Somewhere error");
        }

    }
}

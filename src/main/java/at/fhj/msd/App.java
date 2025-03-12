package at.fhj.msd;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        String filename = "src\\main\\resources\\data.txt";
        var reader = new DataReader(filename); //New Constructor
        ArrayList<String> listOfSchedules = reader.read(); //Call read() Method inside DataReader
        String delimeter = ";";
        ArrayList<Schedule> ValidLines = reader.readData(listOfSchedules, delimeter); //Call readData() from DataReader
        var writer = new DataWriter(); //New Construcotr for DataWriter
        writer.writeSql(ValidLines); //Test with .sql!

        Schedule obj = new Schedule("SWD", "G1", "Software Development II", "2024-02-23 14:00:00", "024-02-23 16:15:00", "Harald Schwab", "Hörsaal (ITM) (WS46b.01.103)");
        // System.out.println(obj.asCsv(":"));  --> Test for asCsv()
        //System.out.println(obj.asSql());  --> Test for asSql()
    }

}

package at.fhj.msd;

import java.util.ArrayList;

public class Schedule {

    private String cohort;
    private String group;
    private String lecture;
    private String starts;
    private String ends;
    private String lecturer;
    private String place;

    public Schedule(String cohort, String group, String lecture, String starts, String ends, String lecturer, String place) {

        if (!cohort.equals("SWD")) {
            throw new IllegalArgumentException("Invalid cohort. Only SWD is valid!"); //Because SWD is only allowed, e.g valid!
        }

        this.cohort = cohort;
        this.group = group;
        this.lecture = lecture;
        this.starts = starts;
        this.ends = ends;
        this.lecturer = lecturer;
        this.place = place;

    }

    //!Getters
    public String GetCohort() {
        return this.cohort;  //Just for test
    }

    public String GetGroup() {
        return this.group;  //Just for test
    }

    public String GetLecture() {
        return this.lecture;  //Just for test
    }

    public String GetStarts() {
        return this.starts;  //Just for test
    }

    public String GetEnds() {
        return this.ends;  //Just for test
    }

    public String GetLecturer() {
        return this.lecturer;  //Just for test
    }

    public String GetPlace() {
        return this.place;  //Just for test
    }

    private ArrayList<String> GetList() {

        ArrayList<String> attributes = new ArrayList<>();
        attributes.add(this.GetCohort());
        attributes.add(this.GetGroup());
        attributes.add(this.GetLecture());
        attributes.add(this.GetStarts());
        attributes.add(this.GetEnds());
        attributes.add(this.GetLecturer());
        attributes.add(this.GetPlace());

        return attributes;

    }

    //! 1. Method
    public String asCsv(String delimeter) {

        ArrayList<String> attributes = GetList();

        String content = "";
        for (String line : attributes) {
            content += line + delimeter;
        }

        return content; //cohort<d>group<d>lecture<d>start<d>end<d>lecturer<d>place

    }

    //! 2. Method
    public String asSql() {

        ArrayList<String> attributes = GetList();
        int commaLine = 0;
        String content = "";
        for (String line : attributes) {
            if (commaLine == 0) {
                commaLine++;
                content += "<" + line + ">";
                continue;
            } content += ",<" + line + ">";
        }

        return "INSERT INTO schedules VALUES (" + content + ")"; //INSERT INTO schedules VALUES (<cohort>,<group>,<lecture>,<start>,<end>,<lecturer>,<place>);
    }

}

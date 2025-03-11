package at.fhj.msd;

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
            throw new IllegalArgumentException("Invalid cohort. Only SWD is valid!");
        }
            
        this.cohort = cohort;
        this.group = group;
        this.lecture = lecture;
        this.starts = starts;
        this.ends = ends;
        this.lecturer = lecturer;
        this.place = place;

    }

    public String GetLecture(){
        return this.lecture;
    }

    public String asCsv(String delimeter) {
        return "";
    }

    public String asSql() {
        return "";
    }

}

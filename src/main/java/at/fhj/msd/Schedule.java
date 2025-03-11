package at.fhj.msd;

public class Schedule {

    private String cohort;
    private String lecture;
    private String group;
    private String starts;
    private String ends;
    private String place;
    private String lecturer;

    public Schedule(String cohort, String group, String lecture, String starts, String ends, String lecturer, String place) {
            
        this.cohort = cohort;
        this.lecture = lecture;
        this.group = group;
        this.starts = starts;
        this.ends = ends;
        this.place = place;
        this.lecturer = lecturer;

    }

    public String asCsv(String delimeter) {
        return "";
    }

    public String asSql() {
        return "";
    }

}

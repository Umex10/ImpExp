package at.fhj.msd;

public class Schedule {

    private String cohort;
    private String group;
    private String lecture;
    private String starts;
    private String ends;
    private String lecturer;
    private String place;

    //! 1. Constructor
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

    //! 1. Method
    public String asCsv(String delimeter) {

        return String.join(delimeter, this.cohort, this.group, this.lecture, this.starts, this.ends, this.lecturer, this.place);

    }

    //! 2. Method
    public String asSql() {

        return String.format("INSERT INTO schedules VALUES ('%s','%s','%s','%s','%s','%s','%s');", this.cohort, this.group,
        this.lecture, this.starts, this.ends, this.lecturer, this.place);

    }

} 

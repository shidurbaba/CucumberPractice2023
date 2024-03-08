package pojo;

public class GetCourse {
    private String instructor;
    private String url;
    private String services;
    private String expertise;
    private Courses courses; //Return type is an object because it is nested JSON; returning getters from Courses to parent class GetCourse
    private String linkedIn;

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getUrl() {
        return url;
    }

    public String getServices() {
        return services;
    }

    public String getExpertise() {
        return expertise;
    }

    public Courses getCourses() {
        return courses;
    }

    public String getLinkedIn() {
        return linkedIn;
    }






}

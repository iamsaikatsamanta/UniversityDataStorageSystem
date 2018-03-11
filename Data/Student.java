package mainPackage.Data;
final public class Student extends Person{
    private String regno;
    private String course;
    private String year;
    private String Project;

    public Student(String name, String address, String number, String regno, String course, String year, String project) {
        super(name, address, number);
        this.regno = regno;
        this.course = course;
        this.year = year;
        Project = project;
    }

    public String getRegno() {
        return regno;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public String getProject() {
        return Project;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setProject(String project) {
        Project = project;
    }
}

import java.util.ArrayList;

public class Course {

    public Course(){

    }
    private String courseId;
    private String courseName;
    private ArrayList<Double> students;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Double> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Double> students) {
        this.students = students;
    }
}

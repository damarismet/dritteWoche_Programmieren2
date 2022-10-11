import java.io.File;
import java.util.ArrayList;
public class Main extends Student {

    public static void main(String[] args) {

        Course course = Reader.readData(new File("/Users/damarismettler/Desktop/Studium FHNW/3. Semester/Programmieren2/dritteWoche_Programmieren2/src/data.txt"));

        if (!course.getStudents().isEmpty()) {
            System.out.println("Grades for: " + course.getCourseName() + " (" + course.getCourseId() +  ")" );
            System.out.println(" -----------------------------------------------------------");
            displayAverageGrades(course.getStudents());
            System.out.println("Number of students read: " + course.getStudents().size());
            System.out.println(" -----------------------------------------------------------");
        } else {
            System.out.println("Unable to read student data, sorry.");
        }

    }
}

import java.io.File;
import java.util.ArrayList;
public class Main extends Student {

    public static void main(String[] args) {

        ArrayList<Student> studentList = Reader.readData(new File("/Users/damarismettler/Desktop/Studium FHNW/3. Semester/Programmieren2/zweiteWoche_Prorgammieren2/src/ch/fhnw/HW/data.txt"));

        if (!studentList.isEmpty()) {
            System.out.println("Number of students read: " + studentList.size());
            displayAverageGrades(studentList);
        } else {
            System.out.println("Unable to read student data, sorry.");
        }

    }
}

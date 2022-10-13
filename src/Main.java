import io.CourseDataReader;
import io.MajorMapReader;
import logic.Course;
import logic.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Main extends Student {

    public static void main(String[] args) {

        MajorMapReader mapReader = new MajorMapReader("src/io/major-map.txt");
        Map<String, String> majormap = mapReader.readMajorMap();

        String file = "src/io/data.txt";
        Optional<Course> oCourse = CourseDataReader.readData(new File(file));
        Course course;
        if (oCourse.isPresent()) {
            course = oCourse.get();

            System.out.println("Grades for: " + course.getCourseName() + " (" + course.getCourseId() + ")");
            System.out.println(" -----------------------------------------------------------");
            displayAverageGrades(course.getStudents());
            System.out.println("Number of students read: " + course.getStudents().size());
            System.out.println(" -----------------------------------------------------------");

        }
        else {
            System.out.println("Unable to read student data, sorry.");
        }

    }

    static void displayAverageGrades(ArrayList<Student> studentList) {
        double summe = 0;
        double lowestgrade = 0;
        double average = 0;

        for (Student student : studentList) {
            average = student.getAverage();
            System.out.println("The average grade for " + student.getName() + " (" + student.getMajor() + ") is: " + Math.round(average * 10) / 10.0);

        }
    }
}

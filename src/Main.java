import io.CourseDataReader;
import io.MajorMapReader;
import logic.Course;
import logic.Student;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public class Main extends Student {

    public static void main(String[] args) {


        String file = "src/io/data.txt";
        Optional<Course> oCourse = CourseDataReader.readData(new File(file));
        Course course;
        if (oCourse.isPresent()) {
            course = oCourse.get();

            System.out.println("Grades for: " + course.getCourseName() + " (" + course.getCourseId() + ")");
            System.out.println(" -----------------------------------------------------------");
            displayAverageGrades(course);
            System.out.println("Number of students read: " + course.getStudents().size());
            System.out.println(" -----------------------------------------------------------");

        }
        else {
            System.out.println("Unable to read student data, sorry.");
        }

    }

    static void displayAverageGrades(Course course) {

        MajorMapReader mapReader = new MajorMapReader("src/io/major-map.txt");
        Map<String, String> majorMap = mapReader.readMajorMap();

        for (Student student : course.getStudents()) {
            String major;
            double preGradeFactor= 0.3;
            if (majorMap.containsKey(student.getMajor())) {
                major = majorMap.get(student.getMajor());
            } else {
                major = student.getMajor();
            }

            System.out.println("The final grade for " + student + " (" + major + ") is: " +
                    Math.round(student.getFinalGrade(preGradeFactor) * 10) / 10.0);
        }
    }
}


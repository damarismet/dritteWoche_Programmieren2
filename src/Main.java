import io.CourseDataReader;
import io.CsvDataReader;
import io.MajorMapReader;
import io.TagValueDataReader;
import logic.Course;
import logic.Student;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public class Main extends Student {



    private static Optional<CourseDataReader> getReader(String fileName) {
        if (fileName.endsWith(".csv")) {
            return Optional.of(new CsvDataReader(fileName));
        } else if (fileName.endsWith(".txt")) {
            return Optional.of(new TagValueDataReader(fileName));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        String fileName = "src/io/grades-v04.csv";
        Optional<CourseDataReader> dataReader = getReader(fileName);
        if (dataReader.isPresent()) {
            Optional<Course> c = dataReader.get().readData(new File(fileName));
            Course course;
           if (c.isPresent()) {
                course = c.get();



        System.out.println("Grades for: " + course.getCourseName() + " (" + course.getCourseId() + ")");
        System.out.println(" -----------------------------------------------------------");
        displayAverageGrades(course);
        System.out.println("Number of students read: " + course.getStudents().size());
        System.out.println(" -----------------------------------------------------------");

        } else {
            System.out.println("Unable to read student data, sorry.");
        }
        }
     else {
        System.out.println("File format unknown for file " + fileName);
    }
}


    static void displayAverageGrades(Course course) {

        MajorMapReader mapReader = new MajorMapReader("src/io/major-map.txt");
        Map<String, String> majorMap = mapReader.readMajorMap();

        for (Student student : course.getStudents()) {
            String major;
            double preGradeFactor = 0.3;
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

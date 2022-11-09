import gui.MainPane;
import io.MajorMapReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Map;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // First, we read in the map that translates the codes for a major to a longer description
        MajorMapReader mapReader = new MajorMapReader("src/io/major-map.txt");
        Map<String, String> majorMap = mapReader.readMajorMap();

        // Create the components (well, just the main one, the rest is in there)
        Pane mainPane = new MainPane(majorMap);
        // Kick-off and wait for events...
        StackPane rootPane = new StackPane(mainPane);
        Scene scene = new Scene(rootPane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Classroom App");
        stage.show();
    }
}


   /* public static void main(String[] args) {
        String fileName = "src/io/grades-v04.csv";
        Optional<CourseDataReader> dataReader = CourseDataReader.getReader(fileName);
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
    }*/


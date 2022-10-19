package io;

import logic.Course;
import logic.Student;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CourseDataReader {

    public static Optional<Course> readData(File file) {
        ArrayList<Student> studentList = new ArrayList<>();

        MajorMapReader mapReader = new MajorMapReader("src/io/major-map.txt");
        Map<String, String> majorMapList = mapReader.readMajorMap();

        String studentName = "";
        String major = "";
        String courseId = "";
        String courseName = "";

        try {
            Scanner scanner = new Scanner(file);

            courseId = scanner.nextLine();
            courseName = scanner.nextLine();
            while (scanner.hasNextLine()) {

                ArrayList<Double> listOfDouble = new ArrayList<>();
                String text = scanner.nextLine();
                String[] elements = text.split(", ");

                studentName = elements[0];
                major = majorMapList.get(elements[1]);

                for (int i = 2; i < elements.length; i++) {

                    listOfDouble.add(Double.parseDouble(elements[i]));
                }

                Student student = new Student(studentName, major, listOfDouble);
                studentList.add(student);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        Course course = new Course(courseId, courseName, studentList);
        return Optional.of(course);
    }
}
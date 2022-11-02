package io;

import logic.Course;

import java.io.File;
import java.util.Optional;

public interface CourseDataReader {

    Optional<Course> readData(File file);
}
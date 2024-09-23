package sis;

import java.util.HashMap;
import java.util.Map;

public class CourseManager {
    private final Map<String, Course> courses = new HashMap<>();

    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    public Course getCourseById(String id) {
        return courses.get(id);
    }
}

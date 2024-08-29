package sis;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private final String id;
    private final String name;
    private final Set<Student> enrolledStudents = new HashSet<>();

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

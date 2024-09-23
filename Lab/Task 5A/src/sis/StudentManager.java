package sis;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private final Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Student getStudentById(String id) {
        return students.get(id);
    }
}

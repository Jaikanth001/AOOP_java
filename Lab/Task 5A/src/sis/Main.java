package sis;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();
        EnrollmentManager enrollmentManager = new EnrollmentManager(studentManager, courseManager);

        Student student1 = new Student("1", "John Doe");
        Student student2 = new Student("2", "Jane Smith");

        studentManager.addStudent(student1);
        studentManager.addStudent(student2);

        Course course1 = new Course("101", "Math 101");
        Course course2 = new Course("102", "Science 101");

        courseManager.addCourse(course1);
        courseManager.addCourse(course2);

        enrollmentManager.enrollStudentInCourse("1", "101");
        enrollmentManager.enrollStudentInCourse("2", "102");

        // Display enrolled students in each course
        course1.getEnrolledStudents().forEach(s -> System.out.println(s.getName() + " is enrolled in " + course1.getName()));
        course2.getEnrolledStudents().forEach(s -> System.out.println(s.getName() + " is enrolled in " + course2.getName()));
    }
}

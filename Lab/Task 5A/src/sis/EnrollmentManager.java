package sis;

public class EnrollmentManager {
    private final StudentManager studentManager;
    private final CourseManager courseManager;

    public EnrollmentManager(StudentManager studentManager, CourseManager courseManager) {
        this.studentManager = studentManager;
        this.courseManager = courseManager;
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = studentManager.getStudentById(studentId);
        Course course = courseManager.getCourseById(courseId);

        if (student != null && course != null) {
            course.enrollStudent(student);
        }
    }
}

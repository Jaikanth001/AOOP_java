package core.service;

import core.entity.Course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseService {
    Connection Conn;
    final String COURSE_TABLE_NAME = "course";
    final String ENROLLMENT_TABLE_NAME = "enrollment";

    CourseService(Connection connection) {
        this.Conn = connection;
    }

    public Course getACourse(int course_id) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE id = %d", COURSE_TABLE_NAME, course_id);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        ArrayList<Course> courses = Course.getCoursesByRS(rs);
        return (courses == null ? null : courses.get(0));
    }

    public ArrayList<Course> getAllCourses() throws SQLException {
        String sql = String.format("SELECT * FROM %s", COURSE_TABLE_NAME);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        return Course.getCoursesByRS(rs);
    }

    public ArrayList<Course> getCoursesOfAnAuthor(int author_id) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE author_id = %d", COURSE_TABLE_NAME, author_id);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        return Course.getCoursesByRS(rs);
    }

    public void insertACourse(Course course) throws SQLException {
        String sql = String.format("INSERT INTO %s (author_id, name, image_path, description, date_created, date_opened) " +
                "VALUES ('%d', '%s', '%s', '%s', '%s', '%s')", COURSE_TABLE_NAME, course.getAuthorID(), course.getName(),
                course.getImagePath(), course.getDescription(), course.getDateCreated(), course.getDateOpened());
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }

    public void updateACourse(Course course, int course_id) throws SQLException {
        String sql = String.format("UPDATE %s " +
                "SET author_id = '%d', name = '%s', image_path = '%s', description = '%s', date_created = '%s', date_opened = '%s' " +
                "WHERE id = %d", COURSE_TABLE_NAME, course.getAuthorID(), course.getName(), course.getImagePath(),
                course.getDescription(), course.getDateCreated(), course.getDateOpened(), course_id);
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }

    public void enroll(int course_id, int user_id) throws SQLException {
        String sql = String.format("INSERT INTO %s (course_id, user_id) " +
                "VALUES (%d, %d)", ENROLLMENT_TABLE_NAME, course_id, user_id);
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }
}

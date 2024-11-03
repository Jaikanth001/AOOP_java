package core.service;

import core.entity.Lesson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LessonService {
    Connection Conn;
    final String LESSON_TABLE_NAME = "lesson";

    LessonService(Connection connection) {
        this.Conn = connection;
    }

    Lesson getALesson(int lesson_id) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE id = %d", LESSON_TABLE_NAME, lesson_id);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        ArrayList<Lesson> lessons = Lesson.getLessonsByRS(rs);
        return (lessons == null ? null : lessons.get(0));
    }

    ArrayList<Lesson> getAllLessons() throws SQLException {
        String sql = String.format("SELECT * FROM %s", LESSON_TABLE_NAME);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        return Lesson.getLessonsByRS(rs);
    }

    ArrayList<Lesson> getLessonsOfACourse(int course_id) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE course_id = %d", LESSON_TABLE_NAME, course_id);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        return Lesson.getLessonsByRS(rs);
    }

    void insertALesson(Lesson lesson) throws SQLException {
        String sql = String.format("INSERT INTO %s (course_id, title, description, content) " +
                "VALUES (%d, '%s', '%s', '%s')", LESSON_TABLE_NAME, lesson.getCourseID(),
                lesson.getTitle(), lesson.getDescription(), lesson.getContent());
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }

    void updateALesson(Lesson lesson, int lesson_id) throws SQLException {
        String sql = String.format("UPDATE %s " +
                "SET course_id = %d, title = '%s', description = '%s', content = '%s' " +
                "WHERE id = %d", LESSON_TABLE_NAME, lesson.getCourseID(), lesson.getTitle(),
                lesson.getDescription(), lesson.getContent(), lesson_id);
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }

    void removeALesson(int lesson_id) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE id = %d", LESSON_TABLE_NAME, lesson_id);
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }
}

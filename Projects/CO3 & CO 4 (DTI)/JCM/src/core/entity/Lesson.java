package core.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JByNine
 */
public class Lesson {
    public Lesson(int id, int courseID, String title, String description, String content) {
        this.ID = id;
        this.CourseID = courseID;
        this.Title = title;
        this.Description = description;
        this.Content = content;
    }

    public int getID() {
        return ID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getContent() {
        return Content;
    }

    public static ArrayList<Lesson> getLessonsByRS(ResultSet rs) throws SQLException {
        ArrayList<Lesson> lessons = new ArrayList<>();
        while (rs.next()) {
            lessons.add(new Lesson(rs.getInt("id"), rs.getInt("course_id"), rs.getString("title"),
                    rs.getString("description"), rs.getString("content")));
        }
        
        return lessons.isEmpty() ? null : lessons;
    }

    private int ID;
    private int CourseID;
    private String Title;
    private String Description;
    private String Content;
}

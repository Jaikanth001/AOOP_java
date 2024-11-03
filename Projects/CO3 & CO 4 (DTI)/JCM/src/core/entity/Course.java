package core.entity;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JByNine
 */
public class Course {
    public Course(int id, int authorID, String name, String imagePath, String description) {
        this.ID = id;
        this.AuthorID = authorID;
        this.Name = name;
        this.ImagePath = imagePath;
        this.Description = description;
        this.DateCreated = this.DateOpened = new java.sql.Timestamp(new java.util.Date().getTime());
    }

    public int getID() {
        return ID;
    }

    public int getAuthorID() {
        return AuthorID;
    }

    public String getName() {
        return Name;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getDescription() {
        return Description;
    }

    public Timestamp getDateCreated() {
        return DateCreated;
    }

    public Timestamp getDateOpened() {
        return DateOpened;
    }
    
    public String getDateCreatedFormat() {
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/YYYY, hh:mm:ss");
        return df.format(this.DateCreated);
    }
    
    public static ArrayList<Course> getCoursesByRS(ResultSet rs) throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()) {
            courses.add(new Course(rs.getInt("id"), rs.getInt("author_id"), rs.getString("name"),
                    rs.getString("image_path"), rs.getString("description")));
        }
        
        return courses.isEmpty() ? null : courses;
    }
    
    private int ID;
    private int AuthorID;
    private String Name;
    private String ImagePath;
    private String Description;
    private java.sql.Timestamp DateCreated;
    private java.sql.Timestamp DateOpened;
    private ArrayList<Student> Students;
    private ArrayList<Lesson> Lessons;
}

package core.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JByNine
 */
public class User {

    public User(int id, String username, String fullName, String avatarPath) {
        this.ID = id;
        this.Username = username;
        this.FullName = fullName;
        this.AvatarPath = avatarPath;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return Username;
    }

    public String getFullName() {
        return FullName;
    }

    public String getAvatarPath() {
        return AvatarPath;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public static ArrayList<User> getUsersByRS(ResultSet rs) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        while (rs.next()) {
            switch (rs.getInt("role")) {
                case 0:
                    // Admin
                case 1:
                    users.add(new Teacher(rs.getInt("id"), rs.getString("username"),
                            rs.getString("full_name"), rs.getString("avatar_path")));
                    break;
                case 2:
                    users.add(new Student(rs.getInt("id"), rs.getString("username"),
                            rs.getString("full_name"), rs.getString("avatar_path")));
                    break;
                default:
                    users.add(new User(rs.getInt("id"), rs.getString("username"),
                            rs.getString("full_name"), rs.getString("avatar_path")));
                    break;
            }
        }

        return users.isEmpty() ? null : users;
    }

    protected int ID;
    protected String Username;
    protected String FullName;
    protected String AvatarPath;
    protected ArrayList<Course> Courses;
}

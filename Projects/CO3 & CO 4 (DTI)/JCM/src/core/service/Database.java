package core.service;

/**
 *
 * @author JByNine
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    Connection Conn;
    public CourseService CourseService;
    public LessonService LessonService;
    public UserService UserService;

    public Database(String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jcm", username, password);
        conn.setAutoCommit(false);
        this.CourseService = new CourseService(conn);
        this.LessonService = new LessonService(conn);
        this.UserService = new UserService(conn);
    }

    public void rollback() throws SQLException {
        this.Conn.rollback();
    }

    public void close() throws SQLException {
        this.Conn.close();
    }
}

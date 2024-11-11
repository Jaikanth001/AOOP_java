import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/studentDetails")
public class StudentDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String program = request.getParameter("program");

        String url = "jdbc:mysql://localhost:3306/Student";
        String user = "yourUsername"; // Change to your DB username
        String password = "yourPassword"; // Change to your DB password

        String sql = "INSERT INTO Registration (name, address, program) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, program);
            pstmt.executeUpdate();

            response.getWriter().println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding student.");
        }
    }
}
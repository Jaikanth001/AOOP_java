public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Student";
        String user = "yourUsername"; // Change to your DB username
        String password = "yourPassword"; // Change to your DB password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE Registration " +
                         "(id INT PRIMARY KEY, " +
                         "name VARCHAR(255), " +
                         "address VARCHAR(255), " +
                         "program VARCHAR(255))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
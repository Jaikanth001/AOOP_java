package core.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MDBConnector {
    private String DB_URL = "jdbc:mysql://localhost:3306";
    private String USER_NAME = "root";
    private String PASSWORD = "";
    private Connection conn = null;
    private static MDBConnector instance =null;
    private boolean stateConnection;

    private MDBConnector() {
        this.DB_URL += "/jcm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Ho_Chi_Minh";//JCM database as default
        this.connect();
    }



    private MDBConnector(String url, String username, String password) {
        this.DB_URL = url;
        this.USER_NAME = username;
        this.PASSWORD = password;
    }

    private Connection connect() {
        conn = getConnectionDriver(this.DB_URL, this.USER_NAME, this.PASSWORD);
        return conn;
    }

    public boolean isConnected() {
        return this.stateConnection;
    }
    public static MDBConnector getInstance() {
        if(instance == null){
            instance = new MDBConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public static MDBConnector getInstance(String url, String username, String password) {
        if(instance == null){
            instance = new MDBConnector(url, username, password);
        }
        return instance;
    }

    private Connection getConnectionDriver(String dbURL, String userName,
                                     String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
            stateConnection = true;
        } catch (Exception ex) {
            System.out.println("connect failure!");
            stateConnection = false;

            ex.printStackTrace();
        }
        return conn;
    }
}

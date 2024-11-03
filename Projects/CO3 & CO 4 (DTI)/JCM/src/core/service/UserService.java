package core.service;

import core.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    Connection Conn;
    final String USER_TABLE_NAME = "user";

    UserService(Connection connection) {
        Conn = connection;
    }
    
    public ArrayList<User> getAllUsers() throws SQLException {
        String sql = String.format("SELECT * FROM %s", USER_TABLE_NAME);
        ResultSet rs = Conn.createStatement().executeQuery(sql);
        return User.getUsersByRS(rs);
    }
    
    public void insertAnUser(User user, String password, int role) throws SQLException {
        String sql = String.format("INSERT INTO %s (username, password, full_name, avatar_path, role) " +
                "VALUES ('%s', '%s', '%s', '%s', %d)", USER_TABLE_NAME, user.getUsername(),
                password, user.getFullName(), user.getAvatarPath(), role);
        Conn.createStatement().executeUpdate(sql);
        Conn.commit();
    }
}

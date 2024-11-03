package core.model;

import java.sql.*;
import java.util.ArrayList;

public class UserModel extends BaseModel {

    protected String Username;
    protected String Password;
    protected String FullName;
    protected String AvatarPath;
    protected int Role;

    private String DEFAULT_QUERY_INSERT = "INSERT INTO %s (username, password, full_name, avatar_path, role) VALUES ( '%s', '%s', '%s' ,'%s' ,%d) ";
    private String DEFAULT_QUERY_UPDATE = "UPDATE %s SET username ='%s', password = '%s' , full_name ='%s', avatar_path ='%s', role =%d ";


    public UserModel(int id) {
        this.table = "user";

        this.setID(id);
        this.select();
    }
    public UserModel(){
        this.table = "user";
    }

    public UserModel(String username, String password, String fullName, String avatarPath, int role) {
        this.table = "user";

        this.Password = password;
        this.Username = username;
        this.FullName = fullName;
        this.AvatarPath = avatarPath;
        this.Role = role;
    }


    //region get set
    public void setRole(int role) {
        Role = role;
    }

    public int getRole() {
        return Role;
    }


    public void setAvatarPath(String avatarPath) {
        AvatarPath = avatarPath;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }


    public void setUsername(String username) {
        Username = username;
    }


    public String getAvatarPath() {
        return AvatarPath;
    }

    public String getFullName() {
        return FullName;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    //endregion


    @Override
    public boolean insert() {
        return this.insert(null, null);
    }

    @Override
    public boolean insert(String query, String whereCondition) {
        String queryString = String.format(DEFAULT_QUERY_INSERT, getTable(), getUsername(), getPassword(), getFullName(), getAvatarPath(), getRole());

        if (query != null) {
            queryString = query;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            //System.out.println(queryString);
            int row_effect = stmt.executeUpdate(queryString);
            return (row_effect > 0 ? true : false);
        } catch (SQLException throwables) {
            System.out.println("[DBHandleException]: Username không được trùng");
            return false;
        }
    }


    @Override
    public boolean update() {
        return update(null, null);
    }

    @Override
    public boolean update(String query, String condition) {
        String queryString = String.format(DEFAULT_QUERY_UPDATE, getTable(), getUsername(), getPassword(), getFullName(), getAvatarPath(), getRole());

        if (query != null) {
            queryString = query;
        }

        if (condition == null) {
            queryString += String.format("WHERE id =%d", getID());
        } else {
            queryString += condition;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            int row_effect = stmt.executeUpdate(queryString);
            return (row_effect > 0 ? true : false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB update()");
            return false;
        }
    }

    @Override
    public boolean remove() {
        return remove(null);
    }

    @Override
    public boolean remove(String condition) {
        String queryString = String.format("DELETE FROM %s ", getTable());
        if (condition == null) {
            queryString += String.format("WHERE id = %d", getID());
        } else {
            queryString += condition;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            int row_effect = stmt.executeUpdate(queryString);
            return (row_effect > 0 ? true : false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB update()");
            return false;
        }
    }

    @Override
    public boolean select() {
        return this.select(null);
    }

    public UserModel parseItem(ResultSet rs) throws SQLException {
        do {
            setID(rs.getInt("id"));
            setUsername(rs.getString("username"));
            setPassword(rs.getString("password"));
            setFullName(rs.getString("full_name"));
            setAvatarPath(rs.getString("avatar_path"));
            setRole(rs.getInt("role"));
            return this;
        } while (rs.next());

    }

    @Override
    public boolean select(String condition) {
        String queryString = String.format("SELECT * FROM %s ", getTable());
        if (condition == null) {
            queryString += String.format("WHERE id = %d", getID());
        } else {
            queryString += condition;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                this.parseItem(rs);
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB select()");
            return false;
        }
    }



    public boolean selectByUserName() {
        String queryString = String.format("SELECT * FROM %s ", getTable());
        queryString += String.format("WHERE username = '%s'", getUsername());

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                this.parseItem(rs);
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB select()");
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s\n" +
                "Username: %s\n" +
                "Password: %s\n" +
                "Fullname: %s\n" +
                "AvatarPath: %s \n" +
                "Role: %d\n" +
                "", getID(), getUsername(), getPassword(), getFullName(), getAvatarPath(), getRole());
    }


}


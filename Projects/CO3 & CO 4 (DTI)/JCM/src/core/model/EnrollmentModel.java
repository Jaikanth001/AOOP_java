package core.model;

import java.sql.*;
import java.util.ArrayList;

public class EnrollmentModel extends BaseModel {

    protected int CourseID;
    protected int UserID;

    private String DEFAULT_QUERY_INSERT = "INSERT INTO %s (course_id, user_id) VALUES ( %d, %d) ";
    private String DEFAULT_QUERY_UPDATE = "UPDATE %s SET course_id = %d, user_id = %d ";
    public EnrollmentModel() {
        this.table = "enrollment";
    }
    public EnrollmentModel(int id) {
        this.table = "enrollment";
        this.setID(id);
        this.select();
    }

    public EnrollmentModel(int course_id, int user_id) {
        this.table = "enrollment";
        this.CourseID = course_id;
        this.UserID = user_id;

    }

    //region get set

    public int getCourseID() {
        return CourseID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }
    //endregion

    @Override
    public boolean insert() {
        return this.insert(null, null);
    }

    @Override
    public boolean insert(String query, String whereCondition) {
        String queryString = String.format(DEFAULT_QUERY_INSERT, getTable(), getCourseID(), getUserID());

        if (query != null) {
            queryString = query;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int row_effect = stmt.executeUpdate(queryString);
            return (row_effect > 0 ? true : false);
        } catch (SQLException throwables) {
            System.out.println(queryString);
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra insert()");
            return false;
        }
    }


    @Override
    public boolean update() {
        return update(null, null);
    }

    @Override
    public boolean update(String query, String condition) {
        String queryString = String.format(DEFAULT_QUERY_UPDATE, getTable(), getCourseID(), getUserID());

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

    public EnrollmentModel parseItem(ResultSet rs) throws SQLException {
        do {
            setID(rs.getInt("id"));
            setCourseID(rs.getInt("course_id"));
            setUserID(rs.getInt("user_id"));
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
    public CourseModel getCourseRelation(){
        CourseModel record = new CourseModel(this.getCourseID());
        return record;
    }
    public UserModel getUserRelation(){
        UserModel record = new UserModel(this.getUserID());
        return record;
    }
    @Override
    public String toString() {
        return String.format("ID: %s\n" +
                "Course_ID: %d\n" +
                "UserID: %d\n" +
                "", getID(), getCourseID(), getUserID());
    }


}


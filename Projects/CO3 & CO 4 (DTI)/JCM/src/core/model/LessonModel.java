package core.model;

import java.sql.*;

public class LessonModel extends BaseModel {

    protected int CourseID;
    protected String Title;
    protected String Description;
    protected String Content;

    private String DEFAULT_QUERY_INSERT = "INSERT INTO %s (course_id, title, description, content) VALUES ( %d, '%s', '%s' ,'%s') ";
    private String DEFAULT_QUERY_UPDATE = "UPDATE %s SET course_id =%d, title = '%s' , description ='%s', content ='%s' ";

    public LessonModel() {
        this.table = "lesson";
    }
    public LessonModel(int id) {
        this.table = "lesson";
        this.setID(id);
        this.select();
    }

    public LessonModel(int course_id, String title, String description, String content) {
        this.table = "lesson";
        this.CourseID = course_id;
        this.Title = title;
        this.Description = description;
        this.Content = content;
    }

    //region get set

    public int getCourseID() {
        return CourseID;
    }

    public String getContent() {
        return Content;
    }

    public String getDescription() {
        return Description;
    }

    public String getTitle() {
        return Title;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTitle(String title) {
        Title = title;
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
        String queryString = String.format(DEFAULT_QUERY_INSERT, getTable(), getCourseID(), getTitle(), getDescription(), getContent());

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
        String queryString = String.format(DEFAULT_QUERY_UPDATE, getTable(), getCourseID(), getTitle(), getDescription(), getContent());

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

    public LessonModel parseItem(ResultSet rs) throws SQLException {
        do {
            setID(rs.getInt("id"));
            setCourseID(rs.getInt("course_id"));
            setTitle(rs.getString("title"));
            setContent(rs.getString("content"));
            setDescription(rs.getString("description"));
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

    @Override
    public String toString() {
        return String.format("ID: %s\n" +
                "Course_ID: %d\n" +
                "Title: %s\n" +
                "Description: %s\n" +
                "Content: %s \n" +
                "", getID(), getCourseID(), getTitle(), getDescription(), getContent());
    }


}


package core.model;

import java.sql.*;
import java.util.ArrayList;

public class CourseModel extends BaseModel {

    protected int AuthorID;
    protected String Name;
    protected String ImagePath;
    protected String Description;
    private java.sql.Timestamp DateCreated;
    private java.sql.Timestamp DateOpened;

    private String DEFAULT_QUERY_INSERT = "INSERT INTO %s (author_id, name, image_path, description, date_created, date_opened) VALUES ( %d, '%s', '%s' ,'%s','%s', '%s') ";
    private String DEFAULT_QUERY_UPDATE = "UPDATE %s SET author_id =%d, name = '%s' , image_path ='%s', description ='%s', date_created ='%s', date_opened ='%s' ";

    public CourseModel(){
        this.table = "course";
    }
    public CourseModel(int id) {
        this.table = "course";
        this.setID(id);
        this.select();
    }
    public CourseModel( String name,String imagePath, String description, Timestamp dateCreated, Timestamp dateOpened){
        this.table  = "course";
        //this.AuthorID = authorID;
        this.Name = name;
        this.ImagePath= imagePath;
        this.Description = description;
        this.DateCreated = dateCreated;
        this.DateOpened = dateOpened;
    }
    public CourseModel(int authorID, String name,String imagePath, String description){
        this.table  = "course";
        this.AuthorID = authorID;
        this.Name = name;
        this.ImagePath= imagePath;
        this.Description = description;
        this.DateCreated = this.DateOpened = new java.sql.Timestamp(new java.util.Date().getTime());
    }

    //region get set
    public String getDateCreatedFormat() {
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/YYYY, hh:mm:ss");
        return df.format(this.DateCreated);
    }
    public String getDescription() {
        return Description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getName() {
        return Name;
    }

    public Timestamp getDateCreated() {
        return DateCreated;
    }

    public Timestamp getDateOpened() {
        return DateOpened;
    }

    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int authorID) {
        AuthorID = authorID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDateCreated(Timestamp dateCreated) {
        DateCreated = dateCreated;
    }

    public void setDateOpened(Timestamp dateOpened) {
        DateOpened = dateOpened;
    }
    //endregion

    @Override
    public boolean insert() {
        return this.insert(null, null);
    }

    @Override
    public boolean insert(String query, String whereCondition) {
        String queryString = String.format(DEFAULT_QUERY_INSERT, getTable(), getAuthorID(), getName(), getImagePath(), getDescription(), getDateCreated(), getDateOpened());

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
        String queryString = String.format(DEFAULT_QUERY_UPDATE, getTable(), getAuthorID(), getName(), getImagePath(), getDescription(), getDateCreated(), getDateOpened());

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

    public CourseModel parseItem(ResultSet rs) throws SQLException {
        do {
            setID(rs.getInt("id"));
            setAuthorID(rs.getInt("author_id"));
            setName(rs.getString("name"));
            setImagePath(rs.getString("image_path"));
            setDescription(rs.getString("description"));
            setDateCreated(rs.getTimestamp("date_created"));
            setDateOpened(rs.getTimestamp("date_opened"));
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
    
     public UserModel getAuthorRelation(){
        UserModel record = new UserModel(this.getAuthorID());
        return record;
    }


    @Override
    public String toString() {
        return String.format("ID: %s\n" +
                "AuthorID: %d\n" +
                "Name: %s\n" +
                "Image Path: %s\n" +
                "Description: %s \n" +
                "Date Created: %s \n" +
                "Date Opened: %s \n", getID(), getAuthorID(), getName(), getImagePath(), getDescription(), getDateCreatedFormat(), getDateOpened());
    }


}


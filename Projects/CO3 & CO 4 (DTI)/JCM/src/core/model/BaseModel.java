package core.model;

import core.database.MDBConnector;

import java.sql.*;
import java.util.ArrayList;

public abstract class BaseModel {
    protected int ID = 0;
    protected String table = null;
    protected MDBConnector mdbConnector;
    protected Connection conn;
    public BaseModel(){
        mdbConnector = MDBConnector.getInstance();
        conn = mdbConnector.getConnection();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract boolean insert();
    public abstract boolean insert(String query, String condition);

    public abstract boolean update();//default by id
    public abstract boolean update(String query, String condition);//default by id

    public abstract boolean remove();
    public abstract boolean remove(String condition);

    public abstract boolean select();

    public abstract boolean select(String condition);
    public abstract <T> T parseItem(ResultSet rs) throws SQLException;


    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}

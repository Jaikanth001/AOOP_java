package core.test;

import core.database.MDBConnector;
import core.model.CourseModel;
import core.model.EnrollmentModel;
import core.model.LessonModel;
import core.model.UserModel;

import java.sql.Connection;
import java.sql.*;

public class TDBConnection {
    public TDBConnection() {}
    public void testConnectToMySQL(){
        MDBConnector mdbConn = MDBConnector.getInstance();
        Connection conn = mdbConn.getConnection();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //region testUserModel
    public void testSelectUserModel() {
        UserModel user = new UserModel(1);
        boolean status = user.select();
        if(status) {
            System.out.println(user.toString());
        }
        else{
            System.out.println("No exist or error");
        }
    }
    public void testInsertUserModel() {
        UserModel user = new UserModel("hocsinh1" ,"admin", "Học sinh", "1",2);
        boolean status = user.insert();
        System.out.println(status ? "OK" : "Error");

    }
    public void testUpdateUserModel() {
        UserModel user = new UserModel("admin" ,"admin", "Trần Minh Đức", "1",1);
        user.setID(1);
        user.setFullName("Đã thay đổi");
        boolean status = user.update(null,null); //update by current id full fields;
        //boolean status = user.update(null, String.format("WHERE username = '%s'", "admin"));
        System.out.println(status ? "OK" : "Error");
    }
    public void testRemoveUserModel() {
        UserModel user = new UserModel(1);
        boolean status = user.remove();//remove default by id
        //boolean status = user.remove("WHERE username='admin1'");//remove default by condition
        System.out.println(status ? "OK" : "Error");
    }
    //endregion


    //region testUserModel
    public void testSelectLessonModel() {
        LessonModel record = new LessonModel(1);
        boolean status = record.select();
        if(status) {
            System.out.println(record.toString());
        }
        else{
            System.out.println("No exist or error");
        }
    }
    public void testInsertLessonModel() {
        LessonModel user = new LessonModel(1, "Lesson 1. Title", "Mô tả nội dung", "Content");
        boolean status = user.insert();
        System.out.println(status ? "OK" : "Error");

    }
    public void testUpdateLessonModel() {
        LessonModel record =new LessonModel(1, "Lesson 1. Title", "Mô tả nội dung", "Content");
        record.setID(1);
        record.setContent("Nội dung  Đã thay đổi");
        boolean status = record.update(null,null); //update by current id full fields;
        //boolean status = user.update(null, String.format("WHERE username = '%s'", "admin"));
        System.out.println(status ? "OK" : "Error");
    }
    public void testRemoveLessonModel() {
        LessonModel records = new LessonModel(1);
        boolean status = records.remove();//remove default by id
        //boolean status = user.remove("WHERE username='admin1'");//remove default by condition
        System.out.println(status ? "OK" : "Error");
    }
    //endregion


    //region testUserModel
    public void testSelectCourseModel() {
        CourseModel record = new CourseModel(1);
        boolean status = record.select();
        if(status) {
            System.out.println(record.toString());
        }
        else{
            System.out.println("No exist or error");
        }
    }
    public void testInsertCourseModel() {
        CourseModel user = new CourseModel(1, "Course 1. Title", "Image Path", "Content");
        boolean status = user.insert();
        System.out.println(status ? "OK" : "Error");

    }
    public void testUpdateCourseModel() {
        CourseModel record =new CourseModel(1, "Course 1. Title", "Image Path", "Content");
        record.setID(1);
        record.setDescription("Nội dung  Đã thay đổi");
        boolean status = record.update(null,null); //update by current id full fields;
        //boolean status = user.update(null, String.format("WHERE username = '%s'", "admin"));
        System.out.println(status ? "OK" : "Error");
    }
    public void testRemoveCourseModel() {
        CourseModel records = new CourseModel(1);
        boolean status = records.remove();//remove default by id
        //boolean status = user.remove("WHERE username='admin1'");//remove default by condition
        System.out.println(status ? "OK" : "Error");
    }
    //endregion


    //region testUserModel
    public void testSelectEnrollmentModel() {
        EnrollmentModel record = new EnrollmentModel(1);
        boolean status = record.select();
        if(status) {
            System.out.println(record.toString());
        }
        else{
            System.out.println("No exist or error");
        }
    }
    public void testInsertEnrollmentModel() {
        EnrollmentModel user = new EnrollmentModel(1,1);
        boolean status = user.insert();
        System.out.println(status ? "OK" : "Error");

    }
    public void testUpdateEnrollmentModel() {
        EnrollmentModel record =new EnrollmentModel(1, 1);
        record.setID(1);
        record.setUserID(2);
        boolean status = record.update(null,null); //update by current id full fields;
        //boolean status = user.update(null, String.format("WHERE username = '%s'", "admin"));
        System.out.println(status ? "OK" : "Error");
    }
    public void testRemoveEnrollmentModel() {
        EnrollmentModel records = new EnrollmentModel(1);
        boolean status = records.remove();//remove default by id
        //boolean status = user.remove("WHERE username='admin1'");//remove default by condition
        System.out.println(status ? "OK" : "Error");
    }
    //endregion
}

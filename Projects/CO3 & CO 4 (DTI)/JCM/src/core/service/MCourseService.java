package core.service;

import core.database.MDBConnector;
import core.entity.AccountEntity;
import core.model.CourseModel;
import core.model.EnrollmentModel;
import core.model.UserModel;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MCourseService {
    public MCourseService() {

    }

    // Lay course bang id
    public CourseModel getCourseByID(int id) {
        CourseModel record = new CourseModel(id);
        boolean status = record.select();
        return (status ? record : null);
    }

    /**
     * Them khoa hoc
     *
     * @param account
     * @param model
     * @return -1: not logined
     * -2: account must be teacher
     * -3: unexpected insert error
     */
    public int insertCourse(AccountEntity account, CourseModel model) {
        if (!account.isLogined()) {
            return -1;
        }
        if (!account.isTeacher()) {
            return -2;
        }
        model.setAuthorID(account.getID());

        boolean status = model.insert();
        if (status) {
            return 0;
        } else {
            return -3;
        }
    }

    /**
     * Xoa khoa hoc course cua tai khoan account
     *
     * @param account
     * @param model
     * @return -1: not logined
     * -2: account must be teacher
     * -3: this post must be of current account
     * -4 : unexpected
     */
    public int removeCourse(AccountEntity account, CourseModel model) {
        if (!account.isLogined()) {
            return -1;
        }
        if (!account.isTeacher()) {
            return -2;
        }
        if (account.getID() != model.getAuthorID()) {
            return -3;
        }
        boolean status = model.remove();
        if (status) {
            return 0;
        } else {
            return -4;
        }
    }

    public ArrayList<CourseModel> getAllCourses() {
        return getListCourseModel(null);
    }

    /**
     * Lay danh sach khoa hoc dang boi tai khoan teacher
     *
     * @param account
     * @return
     */
    public ArrayList<CourseModel> getMyCourses(AccountEntity account) {
        return getListCourseModel(String.format("WHERE author_id ='%s' ", account.getID()));
    }

    /**
     * Lay toan bo danh sach khoa hoc
     *
     * @param condition
     * @return
     */
    public ArrayList<CourseModel> getListCourseModel(String condition) {
        MDBConnector mdbConnector = MDBConnector.getInstance();
        Connection conn = mdbConnector.getConnection();
        ArrayList<CourseModel> list = new ArrayList<CourseModel>();

        String queryString = String.format("SELECT * FROM course ");
        if (condition != null) {
            queryString += condition;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                do {
                    CourseModel model = new CourseModel();
                    model.parseItem(rs);
                    list.add(model);
                }
                while (rs.next());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB select()");
        }
        return list;
    }


    /**
     * Lay danh sach khoa hoc da tham gia
     *
     * @param account
     * @return
     */
    public ArrayList<CourseModel> getEnrolledCourse(AccountEntity account) {
        ArrayList<CourseModel> listCourse = new ArrayList<CourseModel>();
        MDBConnector mdbConnector = MDBConnector.getInstance();
        Connection conn = mdbConnector.getConnection();

        ArrayList<EnrollmentModel> list = new ArrayList<EnrollmentModel>();

        if (!account.isLogined()) {
            System.out.println("Must login");

            return null;
        }
        if (!account.isStudent()) {
            System.out.println("Student permission");
            return null;
        }
        String queryString = String.format("SELECT * FROM enrollment WHERE user_id = %d", account.getID());

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                do {
                    EnrollmentModel model = new EnrollmentModel();
                    model.parseItem(rs);
                    listCourse.add(model.getCourseRelation());
                    list.add(model);
                }
                while (rs.next());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB select()");
        }
        return listCourse;
    }

    /**
     * Lay toan bo hoc sinh cua 1 khoa hoc
     * @param course
     * @return
     */

    public ArrayList<UserModel> getAllParticipants(CourseModel course){
        ArrayList<UserModel> listUserModel = new ArrayList<UserModel>();
        MDBConnector mdbConnector = MDBConnector.getInstance();
        Connection conn = mdbConnector.getConnection();


        ArrayList<EnrollmentModel> list = new ArrayList<EnrollmentModel>();

        String queryString = String.format("SELECT * FROM enrollment WHERE course_id = %d", course.getID());

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println(queryString);
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                do {
                    EnrollmentModel model = new EnrollmentModel();
                    model.parseItem(rs);
                    listUserModel.add(model.getUserRelation());
                    list.add(model);
                }
                while (rs.next());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("[DBHandleException]: Có lỗi xảy ra DB select()");
        }
        return listUserModel;
    }
    /**
     *  
     * @param account
     * @param course
     * @return 
     *  -1 : login
     *  -2 : student permission
     *  -3 : enrolled
     *  -4 : unexpected
     */
    public int enrollACourse(AccountEntity account, CourseModel course){
        if(!account.isLogined()){
            return -1;
        }
        if(!account.isStudent()){
            return -2;
        }
        
        int course_id = course.getID();
        int user_id = account.getID();
        //EnrollmentModel enrollRecord  = new EnrollmentModel( course_id, user_id );
        EnrollmentModel checkExist = new EnrollmentModel();
        boolean status = checkExist.select(String.format("WHERE course_id = %d AND user_id = %d", course_id, user_id));
        if(status){
            //record existed
            return -3;
        }
        else{
            checkExist.setCourseID(course_id);
            checkExist.setUserID(user_id);
            if(checkExist.insert()){
                return 0;
            }
            else{
                return -4;
            }
        }
    }
    
    /**
     *  
     * @param account
     * @param course
     * @return 
     *  -1 : login
     *  -2 : student permission
     *  -3 : unexpected
     */
    public int unenrollACourse(AccountEntity account, CourseModel course) {
        if(!account.isLogined()){
            return -1;
        }
        if(!account.isStudent()){
            return -2;
        }
        
        int course_id = course.getID();
        int user_id = account.getID();
        EnrollmentModel checkExist = new EnrollmentModel();
        if(checkExist.remove(String.format("WHERE course_id = %d and user_id = %d", course_id, user_id))){
            return 0;
        }
        else{
            return -3;
        }
    }
    
    /**
     * 
     * @param account
     * @param user_id
     * @param course
     * @return
     *  -1 : not login
     *  -2 : teacher permission
     *  -3 : teacher of this course
     *  -4 : user participant not exist
     *  -5 : user enrolled
     *  -6 : just student
     *  -7 : unexpected
     *   0 : success
     */     
    public int addParticipant(AccountEntity account, int user_id, CourseModel course) {
        if (!account.isLogined()) {
            return -1;
        }
        if (!account.isTeacher()) {
            return -2;
        }
        if (course.getAuthorID() != account.getID()) {
            return -3;
        }

        int course_id = course.getID();
        UserModel check_user = new UserModel(user_id);
        
        if (check_user.getRole() != 2) {
            return -6;
        }

        if (check_user.select()) {
            EnrollmentModel checkExist = new EnrollmentModel();
            boolean status = checkExist.select(String.format("WHERE course_id = %d AND user_id = %d", course_id, user_id));
            if (status) {
                //record existed
                return -5;
            } else {
                checkExist.setCourseID(course_id);
                checkExist.setUserID(user_id);
                if (checkExist.insert()) {
                    return 0;
                } else {
                    return -7;
                }
            }
        } else {
            return -4; //user participant not existted
        }
    }
}

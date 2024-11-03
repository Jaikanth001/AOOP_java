package core.service;

import core.database.MDBConnector;
import core.entity.AccountEntity;
import core.model.CourseModel;
import core.model.LessonModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MLessonService {
    public MLessonService() {

    }

    /**
     * Them moi lesson
     *
     * @param account
     * @param course_id
     * @param model
     * @return -1: not login
     * -2: must be teacher
     * -3: exception error
     */
    public int insertLesson(AccountEntity account, int course_id, LessonModel model) {
        if (!account.isLogined()) {
            return -1;
        }
        if (!account.isTeacher()) {
            return -2;
        }

        model.setCourseID(course_id);

        boolean status = model.insert();
        if (status) {
            return 0;
        } else {
            return -3;
        }
    }


    public ArrayList<LessonModel> getAllLessonOfCourse(CourseModel course) {
        return getListLessonModel(String.format("WHERE course_id = %d ", course.getID()));
    }

    /**
     * Lay toan bo danh sach khoa hoc
     *
     * @param condition
     * @return
     */
    public ArrayList<LessonModel> getListLessonModel(String condition) {
        MDBConnector mdbConnector = MDBConnector.getInstance();
        Connection conn = mdbConnector.getConnection();
        ArrayList<LessonModel> list = new ArrayList<LessonModel>();

        String queryString = String.format("SELECT * FROM lesson ");
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
                    LessonModel model = new LessonModel();
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


}

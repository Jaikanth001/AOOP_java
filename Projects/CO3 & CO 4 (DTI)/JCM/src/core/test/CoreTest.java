package core.test;

import core.entity.AccountEntity;
import core.model.CourseModel;
import core.model.UserModel;
import core.service.MCourseService;

import java.util.ArrayList;

abstract class Parent {
    protected String name ="Duc";

    public abstract boolean insert();
    public abstract ArrayList<? extends Parent> get();
}

class A extends Parent{
    protected String age = "123";
    public A (String age) {
         this.age = age;
    }
    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public ArrayList<A> get() {
        ArrayList<A> list = new ArrayList<A>();
        list.add(new A("12312321"));
        return list ;
    }

    @Override
    public String toString() {
        return "A{" +
                "age='" + age + '\'' +
                '}';
    }
}

public class CoreTest {
    public static void testTDB() {

//        TDBConnection tdb = new TDBConnection();

//        tdb.testInsertUserModel();
//        tdb.testSelectUserModel();
//        tdb.testUpdateUserModel();
//        tdb.testRemoveUserModel();
//
//        tdb.testInsertCourseModel();
//        tdb.testSelectCourseModel();
//        tdb.testUpdateCourseModel();
//        tdb.testRemoveCourseModel();
//
//
//        tdb.testInsertLessonModel();
//        tdb.testSelectLessonModel();
//        tdb.testUpdateLessonModel();
//        tdb.testRemoveLessonModel();


        //tdb.testInsertEnrollmentModel();
        // tdb.testSelectEnrollmentModel();
        // tdb.testUpdateEnrollmentModel();
        //tdb.testRemoveEnrollmentModel();
    }
    public static void testCourseService() {
        MCourseService course = new MCourseService() ;
        AccountEntity account = new AccountEntity();
        int loginState= account.login("hocsinh", "admin");
        if(loginState == 0) {
            ArrayList<UserModel> mycourses = course.getAllParticipants(new CourseModel(3));
            for (UserModel ct : mycourses) {
                System.out.println(ct);
            }
        }
        else{
            System.out.println("Relogin");
        }
    }
    public static void main(String[] args) {
        testCourseService();
    }
}

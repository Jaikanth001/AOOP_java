package core.entity;

public class TeacherEntity extends AccountEntity {

    public TeacherEntity() {

    }

    public int register(String username, String password, String repassword, String fullName) {
        return super.register(username, password, repassword, fullName, 1);
    }
}

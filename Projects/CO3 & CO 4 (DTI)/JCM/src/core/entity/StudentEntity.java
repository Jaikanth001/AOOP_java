package core.entity;

public class StudentEntity extends AccountEntity{

    public int register(String username, String password, String repassword, String fullName) {
        return super.register(username, password, repassword, fullName, 0);
    }

}

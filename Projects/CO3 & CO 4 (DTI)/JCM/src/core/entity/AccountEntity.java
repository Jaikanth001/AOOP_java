package core.entity;

import core.model.UserModel;

public class AccountEntity {
    private boolean _logined;
    private UserModel _user;

    public AccountEntity() {
        _logined = false;
        _user = null;
    }

    public void logout() {
        _logined = false;
        _user = null;
    }
    public int getID(){
        return _user.getID();
    }
    public boolean isTeacher() {
        if (_user !=null){
            if(_user.getRole() == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        return  false;
    }
    public boolean isStudent() {
        if (_user !=null){
            if(_user.getRole() == 2) {
                return true;
            }
            else {
                return false;
            }
        }
        return  false;
    }
    /**
     * Login account by user and pass
     *
     * @param username
     * @param password
     * @return: -1 if account not existed
     * -2 if password incorrect
     * 0 success and save model to user
     */
    public int login(String username, String password) {
        UserModel user = new UserModel();
        user.setUsername(username);

        boolean status = user.selectByUserName();
        if (status == false) {
            return -1;
        } else {
            if (user.getPassword().equals(password)) {
                _user = user;
                _logined = true;
                return 0;
            } else {
                return -2;
            }
        }
    }

    //role 1 - teacher, 2 - student

    /**
     * Register core
     * @param username
     * @param password
     * @param repassword
     * @param fullName
     * @param role
     * @return
     *  -1 : pass != repass
     *  -2 : user_existed
     *  -3 : unexpected error
     */
    public int register(String username, String password, String repassword, String fullName, int role) {
        UserModel user = new UserModel();
        user.setUsername(username);
        boolean status = user.selectByUserName();
        if (!password.equals(repassword)){
            return -1;
        }
        if (status == true){
            return -2;  //user existed
        }
        if (fullName.isEmpty()){
            fullName = "Account Name";
        }
        UserModel record = new UserModel(username, password, fullName, "/ui/assets/avatars/default.png", role);
        boolean status_insert = record.insert();
        if(status_insert == true){
            return 0;
        }
        else{
            return -3;
        }
    }


    public UserModel getUserModel() {
        return _user;
    }

    public boolean isLogined()
    { return this._logined;}

}

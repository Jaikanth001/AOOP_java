package ridesharing.authentication;

public class UserAuthentication {
    private static UserAuthentication instance;
    private boolean authenticated;
    private String userName;

    private UserAuthentication() {}

    public static UserAuthentication getInstance() {
        if (instance == null) {
            instance = new UserAuthentication();
        }
        return instance;
    }

    public void login(String userName) {
        this.userName = userName;
        this.authenticated = true;
        System.out.println(userName + " logged in.");
    }

    public void logout() {
        userName = null;
        authenticated = false;
        System.out.println("User logged out.");
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUserName() {
        return userName;
    }
}

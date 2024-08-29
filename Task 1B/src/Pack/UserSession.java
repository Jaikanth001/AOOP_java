package Pack;

public class UserSession {
    private static UserSession instance;
    private boolean loggedIn;
    private String userName;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void login(String userName) {
        this.userName = userName;
        this.loggedIn = true;
        System.out.println(userName + " logged in.");
    }

    public void logout() {
        userName = null;
        loggedIn = false;
        System.out.println("User logged out.");
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
}


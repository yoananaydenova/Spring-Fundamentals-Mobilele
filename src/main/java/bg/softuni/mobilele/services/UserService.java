package bg.softuni.mobilele.services;

public interface UserService {

    /**
     *
     * @param userName
     * @param password
     * @return returns true if the user is authenticated successfully.
     */
    boolean authenticate(String userName, String password);

    void loginUser(String userName);

    void logoutCurrentUser();
}

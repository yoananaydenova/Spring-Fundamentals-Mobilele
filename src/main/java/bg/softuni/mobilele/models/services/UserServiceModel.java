package bg.softuni.mobilele.models.services;

import java.util.List;

public class UserServiceModel extends BaseServiceModel{

    private String username;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    private List<UserRoleServiceModel> userRoles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<UserRoleServiceModel> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleServiceModel> userRoles) {
        this.userRoles = userRoles;
    }
}

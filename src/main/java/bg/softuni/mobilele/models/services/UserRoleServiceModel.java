package bg.softuni.mobilele.models.services;

import bg.softuni.mobilele.models.entities.enums.UserRoleEnum;


public class UserRoleServiceModel {

    private Long id;
    private UserRoleEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}

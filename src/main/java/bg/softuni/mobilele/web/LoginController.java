package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.services.UserLoginServiceModel;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    private final UserService userService;

    @Autowired
    public LoginController( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String showLogin() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginServiceModel userLoginServiceModel) {
        if (userService.authenticate(userLoginServiceModel.getUsername(), userLoginServiceModel.getPassword())) {
            userService.loginUser(userLoginServiceModel.getUsername());
            return "redirect:/";
        }else{
            return "redirect:/users/login";
        }
    }

    @PostMapping("/users/logout")
    public String logout() {
        this.userService.logoutCurrentUser();
        return "redirect:/";
    }
}



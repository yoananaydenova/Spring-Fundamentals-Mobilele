package bg.softuni.mobilele.web;

import bg.softuni.mobilele.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final CurrentUser currentUser;

    @Autowired
    public LoginController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }
}



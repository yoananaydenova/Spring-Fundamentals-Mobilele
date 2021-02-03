package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String userName, String password) {
        Optional<UserEntity> userEntityOpt = this.userRepository.findByUsername(userName);

        if (userEntityOpt.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userEntityOpt.get().getPassword());
        }
    }

    @Override
    public void loginUser(String userName) {
        currentUser.setAnonymous(false);
        currentUser.setName(userName);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }


}

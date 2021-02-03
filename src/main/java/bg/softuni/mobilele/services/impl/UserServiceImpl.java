package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.models.entities.enums.UserRoleEnum;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        UserEntity user = this.userRepository.findByUsername(userName).orElseThrow();

        List<UserRoleEnum> userRoles = user
                .getUserRoles()
                .stream()
                .map(ur -> ur.getRole())
                .collect(Collectors.toList());

        currentUser.setAnonymous(false);

        currentUser.setName(user.getUsername())
                .setUserRoles(userRoles);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }


}

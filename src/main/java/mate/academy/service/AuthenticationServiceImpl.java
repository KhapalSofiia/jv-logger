package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogManager().getLogger(AuthenticationServiceImpl.class.getName());

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Method login was called for login: " + login);
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            logger.severe("Username or password are incorrect for login: " + login);
        }
        return user;
    }

    private User findByLogin(String login) {
        User user = new User(login, "1234");
        // this user identifier should be set by DB. We will use dummy data for this example
        user.setUserId(2L);
        return user;
    }
}

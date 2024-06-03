package rs.ac.metropolitan.projekatit355.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.projekatit355.exceptions.UsernameExistsException;
import rs.ac.metropolitan.projekatit355.model.User;
import rs.ac.metropolitan.projekatit355.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User registerNewUserAccount(User user) throws UsernameExistsException {

        if (usernameExist(user.getUsername())) {
            throw new UsernameExistsException("There is an account with that username: " + user.getUsername());
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setPasswordConfirmation(user.getPasswordConfirmation());
        newUser.setRole("USER");

        System.out.println(newUser);
        return userRepository.save(newUser);

    }

    private boolean usernameExist(String username) {
        User user = userRepository.findByUsername(username);

        return user != null;
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

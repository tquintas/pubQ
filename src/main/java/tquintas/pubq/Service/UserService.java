package tquintas.pubq.Service;

import tquintas.pubq.Model.*;

public interface UserService {
    User createUser(User user);
    User getUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    User validateLogin(User user);
    User getUserById(Long id);
}

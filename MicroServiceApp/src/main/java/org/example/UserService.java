package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<UserEntity> users = new ArrayList<>();
    private Long idCounter = 1L;

    public List<UserEntity> getAllUsers() {
        return users;
    }

    public UserEntity getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public UserEntity createUser(UserEntity user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}

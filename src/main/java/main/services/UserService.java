package main.services;

import lombok.AllArgsConstructor;
import main.entitys.User;
import main.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        userRepo.findAll().forEach(userList::add);
        return userList;
    }

    public User save(User user) {
        User savedUser = new User();
        if (user != null) {
            savedUser = userRepo.save(user);
        }
        return savedUser;
    }

    public User getById(long id) {
        Optional<User> userById = userRepo.findById(id);
        return userById.orElse(null);
    }
}

package com.gui0103.stocks_buyer.service;

import com.gui0103.stocks_buyer.model.User;
import com.gui0103.stocks_buyer.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User setUser(User user) {
        return userRepository.save(user);
    }

    public void setUserName(Long id, String name) {
        User user = getUserById(id);
        user.setName(name);
        userRepository.save(user);
    }
}

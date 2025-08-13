package com.gui0103.stocks_buyer.controller;

import com.gui0103.stocks_buyer.dto.UserDTO;
import com.gui0103.stocks_buyer.model.User;
import com.gui0103.stocks_buyer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream()
                .map(UserDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return UserDTO.fromEntity(userService.getUserById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody User user) {
        return UserDTO.fromEntity(userService.setUser(user));
    }

    @PatchMapping("/{id}/name")
    public void updateUserName(@PathVariable Long id, @RequestParam String name) {
        userService.setUserName(id, name);
    }
}

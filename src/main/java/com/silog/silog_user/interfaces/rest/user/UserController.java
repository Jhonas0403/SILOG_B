package com.silog.silog_user.interfaces.rest.user;

import com.silog.silog_user.application.service.User.PutUserService;
import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.*;
import com.silog.silog_user.interfaces.rest.user.dto.UpdateRequestUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private  final CreateUserUseCase createUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final PutUserUseCase putUserUseCase;
    private final PatchUserUseCase patchUserUseCase;

    public  UserController(PatchUserUseCase patchUserUseCase,GetUserByIdUseCase getUserByIdUseCase , CreateUserUseCase createUserUseCase, GetUsersUseCase getUsersUseCase, PutUserUseCase putUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.putUserUseCase = putUserUseCase;
        this.patchUserUseCase = patchUserUseCase;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = createUserUseCase.create(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = getUsersUseCase.getUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = getUserByIdUseCase.findById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User userU = putUserUseCase.update(user);
        return ResponseEntity.ok(userU);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody UpdateRequestUser user) {
        User userU = patchUserUseCase.patch(id, user);
        return ResponseEntity.ok(userU);
    }
}

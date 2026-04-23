package com.silog.silog_user.interfaces.rest.user;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.*;
import com.silog.silog_user.interfaces.rest.user.dto.UpdateRequestUser;
import com.silog.silog_user.interfaces.rest.user.dto.UserRequest;
import com.silog.silog_user.interfaces.rest.user.dto.UserResponse;
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
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest user) {
        User createdUser = createUserUseCase.create(user.toDomain());
        return ResponseEntity.ok(UserResponse.fromDomain(createdUser));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<User> users = getUsersUseCase.getUsers();
        return ResponseEntity.ok(users.stream().map(UserResponse::fromDomain).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        User user = getUserByIdUseCase.findById(id);
        return ResponseEntity.ok(UserResponse.fromDomain(user));
    }
    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest user) {
        User userU = putUserUseCase.update(user.toDomain());
        return ResponseEntity.ok(UserResponse.fromDomain(userU));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id, @RequestBody UpdateRequestUser user) {
        User userU = patchUserUseCase.patch(id, user.toDomain());
        return ResponseEntity.ok(UserResponse.fromDomain(userU));
    }
}

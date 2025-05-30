package project.gitclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gitclone.entity.UserEntity;
import project.gitclone.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getUser(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}

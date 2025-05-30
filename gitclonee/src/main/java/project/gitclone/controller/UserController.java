package project.gitclone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gitclone.entity.UserEntity;
import project.gitclone.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection (preferred over @Autowired on fields)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /api/users
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }
}

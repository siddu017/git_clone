package project.gitclone.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gitclone.entity.Role;
import project.gitclone.entity.UserEntity;
import project.gitclone.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create or update a user
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find all users with a specific role (e.g., EMPLOYEE, TEAM_LEADER)
    public List<UserEntity> findUsersByRole(Role role) {


        return userRepository.findByRole(String.valueOf(role));
    }

    // Convert string to Role and fetch users (useful if input is from a request)
    public List<UserEntity> findUsersByRoleName(String roleName) {
        try {
            Role role = Role.valueOf(roleName.toUpperCase());
            return userRepository.findByRole(String.valueOf(role));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + roleName);
        }
    }
}
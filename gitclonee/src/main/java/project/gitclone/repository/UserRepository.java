package project.gitclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gitclone.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String Username);
    List<UserEntity> findByRole(String Role);
}

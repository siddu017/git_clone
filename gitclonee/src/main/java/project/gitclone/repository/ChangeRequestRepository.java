package project.gitclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gitclone.entity.ChangeRequestEntity;
import project.gitclone.entity.UserEntity;

import java.util.List;

public interface ChangeRequestRepository extends JpaRepository<ChangeRequestEntity, Long> {
    List<ChangeRequestEntity> findByStatus(String status); // e.g., "PENDING_REVIEW", "COMMITTED"
    List<ChangeRequestEntity> findBySubmittedBy(UserEntity user);
}


package project.gitclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gitclone.entity.ChangeRequestEntity;
import project.gitclone.entity.CommentEntity;
import project.gitclone.entity.UserEntity;

import java.util.List;

public interface CommentLogRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByChangeRequest(ChangeRequestEntity changeRequest);
    List<CommentEntity> findByCreatedBy(UserEntity user);
}

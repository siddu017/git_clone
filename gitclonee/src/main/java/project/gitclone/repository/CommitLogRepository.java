package project.gitclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gitclone.entity.CommitLogEntity;
import project.gitclone.entity.FileEntity;
import project.gitclone.entity.UserEntity;

import java.util.List;

public interface CommitLogRepository extends JpaRepository<CommitLogEntity, Long> {
    List<CommitLogEntity> findByCommittedBy(UserEntity user);
    List<CommitLogEntity> findByFile(FileEntity file);
}

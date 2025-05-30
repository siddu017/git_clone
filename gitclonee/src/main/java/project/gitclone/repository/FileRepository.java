package project.gitclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gitclone.entity.FileEntity;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByFilePath(String filePath);
}

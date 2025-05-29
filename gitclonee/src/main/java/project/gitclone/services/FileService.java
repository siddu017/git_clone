package project.gitclone.services;

import org.springframework.stereotype.Service;
import project.gitclone.entity.FileEntity;
import project.gitclone.repository.FileRepository;

@Service
public class FileService {
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileEntity getFileByPath(String filePath) {
        return fileRepository.findByFilePath(filePath)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    public FileEntity saveFile(FileEntity file) {
        return fileRepository.save(file);
    }
}
package project.gitclone.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private String fileName;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String branchName;

    private LocalDateTime lastModified;

    @ManyToOne
    @JoinColumn(name = "last_modified_by_id")
    private UserEntity lastModifiedBy;

    public FileEntity() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public LocalDateTime getLastModified() { return lastModified; }
    public void setLastModified(LocalDateTime lastModified) { this.lastModified = lastModified; }

    public UserEntity getLastModifiedBy() { return lastModifiedBy; }
    public void setLastModifiedBy(UserEntity lastModifiedBy) { this.lastModifiedBy = lastModifiedBy; }
}

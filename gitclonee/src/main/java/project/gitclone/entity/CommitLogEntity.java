package project.gitclone.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "commit_logs")
public class CommitLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "file_id", nullable = false)
    private FileEntity file;

    @Lob
    @Column(nullable = false)
    private String committedContent;

    @Column(nullable = false)
    private String commitMessage;

    @Column(nullable = false)
    private int versionNumber;

    @Column(nullable = false)
    private String branchName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "committed_by", nullable = false)
    private UserEntity committedBy;

    private LocalDateTime committedAt;

    public CommitLogEntity() {}

    // Getters and setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FileEntity getFile() { return file; }
    public void setFile(FileEntity file) { this.file = file; }

    public String getCommittedContent() { return committedContent; }
    public void setCommittedContent(String committedContent) { this.committedContent = committedContent; }

    public String getCommitMessage() { return commitMessage; }
    public void setCommitMessage(String commitMessage) { this.commitMessage = commitMessage; }

    public int getVersionNumber() { return versionNumber; }
    public void setVersionNumber(int versionNumber) { this.versionNumber = versionNumber; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public UserEntity getCommittedBy() { return committedBy; }
    public void setCommittedBy(UserEntity committedBy) { this.committedBy = committedBy; }

    public LocalDateTime getCommittedAt() { return committedAt; }
    public void setCommittedAt(LocalDateTime committedAt) { this.committedAt = committedAt; }
}

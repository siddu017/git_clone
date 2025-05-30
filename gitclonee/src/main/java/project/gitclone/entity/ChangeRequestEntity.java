package project.gitclone.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "change_requests")
public class ChangeRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "file_id", nullable = false)
    private FileEntity file;

    @Lob
    @Column(nullable = false)
    private String newContent;

    private String commitMessage;

    @Column(nullable = false)
    private String branchName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChangeStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "submitted_by", nullable = false)
    private UserEntity submittedBy;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "reviewed_by")
    private UserEntity reviewedBy;

    private LocalDateTime reviewedAt;

    @OneToMany(mappedBy = "changeRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

    public ChangeRequestEntity() {}

    // Getters and setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public FileEntity getFile() { return file; }
    public void setFile(FileEntity file) { this.file = file; }

    public String getNewContent() { return newContent; }
    public void setNewContent(String newContent) { this.newContent = newContent; }

    public String getCommitMessage() { return commitMessage; }
    public void setCommitMessage(String commitMessage) { this.commitMessage = commitMessage; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public ChangeStatus getStatus() { return status; }
    public void setStatus(ChangeStatus status) { this.status = status; }

    public UserEntity getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(UserEntity submittedBy) { this.submittedBy = submittedBy; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }

    public UserEntity getReviewedBy() { return reviewedBy; }
    public void setReviewedBy(UserEntity reviewedBy) { this.reviewedBy = reviewedBy; }

    public LocalDateTime getReviewedAt() { return reviewedAt; }
    public void setReviewedAt(LocalDateTime reviewedAt) { this.reviewedAt = reviewedAt; }

    public List<CommentEntity> getComments() { return comments; }
    public void setComments(List<CommentEntity> comments) { this.comments = comments; }
}

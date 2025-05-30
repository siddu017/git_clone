package project.gitclone.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String commentText;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "change_request_id")  // ✅ This is required
    private ChangeRequestEntity changeRequest;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        thpackage project.gitclone.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

        @Entity
        @Table(name = "comments")
        public class CommentEntity {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @Lob
            @Column(nullable = false)
            private String commentText;

            private LocalDateTime createdAt;

            @ManyToOne
            @JoinColumn(name = "created_by_id", nullable = false)
            private UserEntity createdBy;

            @ManyToOne
            @JoinColumn(name = "change_request_id", nullable = false)
            private ChangeRequestEntity changeRequest;

            public CommentEntity() {}

            // Getters and setters...
            public Long getId() { return id; }
            public void setId(Long id) { this.id = id; }

            public String getCommentText() { return commentText; }
            public void setCommentText(String commentText) { this.commentText = commentText; }

            public LocalDateTime getCreatedAt() { return createdAt; }
            public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

            public UserEntity getCreatedBy() { return createdBy; }
            public void setCreatedBy(UserEntity createdBy) { this.createdBy = createdBy; }

            public ChangeRequestEntity getChangeRequest() { return changeRequest; }
            public void setChangeRequest(ChangeRequestEntity changeRequest) { this.changeRequest = changeRequest; }
        }
        is.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public ChangeRequestEntity getChangeRequest() {
        return changeRequest;
    }

    public void setChangeRequest(ChangeRequestEntity changeRequest) {
        this.changeRequest = changeRequest;
    }
}

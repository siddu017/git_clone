package project.gitclone.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    public class CommentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String text;

        @ManyToOne
        @JoinColumn(name = "author_id", nullable = false)
        private UserEntity author;

        private LocalDateTime createdAt;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public UserEntity getAuthor() {
            return author;
        }

        public void setAuthor(UserEntity author) {
            this.author = author;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }



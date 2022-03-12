package com.example.historydiseases.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

import com.example.historydiseases.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Getter
@Setter
@Table(name = "client_images")
public class ProfileImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "photo_id")
    private String photoId;

    @ManyToOne()
    @JoinColumn(name = "request_id")
    private ProfileRequest clientRequest;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modified;
}

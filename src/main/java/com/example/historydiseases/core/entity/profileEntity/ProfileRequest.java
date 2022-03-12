package com.example.historydiseases.core.entity.profileEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.Map;

import com.example.historydiseases.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@Table(name = "client_requests")
public class ProfileRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "data", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Map<String, String> data;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modified;
}
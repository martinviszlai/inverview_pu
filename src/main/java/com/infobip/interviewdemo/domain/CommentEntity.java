package com.infobip.interviewdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodeReviewId")
    private CodeReviewEntity codeReview;

    private String content;
    private String author;
    private String position;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant resolvedAt;

    @Enumerated(EnumType.ORDINAL)
    private CommentType type;
}

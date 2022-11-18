package com.infobip.interviewdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "code_review")
public class CodeReviewEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String sourceBranch;
    private String targetBranch;
    private String author;

    @ElementCollection
    @CollectionTable(name = "code_review_reviewers", joinColumns = @JoinColumn(name = "id"))
    @Column
    private List<String> reviewers;

    @Enumerated(EnumType.STRING)
    private CodeReviewState state;
}

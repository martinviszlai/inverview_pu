package com.infobip.interviewdemo.dto;

import com.infobip.interviewdemo.domain.CodeReviewState;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CodeReviewDetailResponse {

    private Long id;
    private String name;
    private String sourceBranch;
    private String targetBranch;
    private String author;
    private List<String> reviewers;
    private CodeReviewState state;
    private Long commentsCount;
}

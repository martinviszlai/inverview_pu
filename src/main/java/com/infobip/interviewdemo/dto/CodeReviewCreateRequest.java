package com.infobip.interviewdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CodeReviewCreateRequest {

    private String name;
    private String sourceBranch;
    private String targetBranch;
    private String author;
    private List<String> reviewers;
}

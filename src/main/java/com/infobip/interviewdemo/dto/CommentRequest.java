package com.infobip.interviewdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentRequest {

    private Long codeReviewId;
    private String content;
    private String author;
    private String position;
    private Long createdAt;
    private Long updatedAt;
    private Long resolvedAt;
    private Boolean isTask;

}

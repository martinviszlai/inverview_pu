package com.infobip.interviewdemo.service;

import com.infobip.interviewdemo.domain.CodeReviewEntity;
import com.infobip.interviewdemo.domain.CodeReviewState;
import com.infobip.interviewdemo.dto.CodeReviewCreateRequest;
import com.infobip.interviewdemo.dto.CodeReviewDetailResponse;
import com.infobip.interviewdemo.repository.CodeReviewRepository;
import com.infobip.interviewdemo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CodeReviewService {

    private final CodeReviewRepository codeReviewRepository;
    private final CommentRepository commentRepository;

    public Long createCodeReview(CodeReviewCreateRequest codeReviewRequest) {
        var codeReviewEntity = mapRequestToEntity(codeReviewRequest);
        codeReviewEntity.setState(CodeReviewState.OPEN);

        codeReviewRepository.save(codeReviewEntity);

        return codeReviewEntity.getId();
    }

    public CodeReviewDetailResponse getCodeReview(Long id) {
        var codeReview = codeReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Code review with provided id not found!"));
        var commentsCount = commentRepository.countAllByCodeReview_Id(id);

        return mapEntityToResponse(codeReview, commentsCount);
    }

    private CodeReviewDetailResponse mapEntityToResponse(CodeReviewEntity entity, Long commentsCount) {
        return CodeReviewDetailResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .sourceBranch(entity.getSourceBranch())
                .targetBranch(entity.getTargetBranch())
                .author(entity.getAuthor())
                .reviewers(entity.getReviewers())
                .state(entity.getState())
                .commentsCount(commentsCount)
                .build();
    }

    private CodeReviewEntity mapRequestToEntity(CodeReviewCreateRequest codeReviewRequest) {
        var codeReviewEntity = new CodeReviewEntity();
        codeReviewEntity.setName(codeReviewRequest.getName());
        codeReviewEntity.setSourceBranch(codeReviewRequest.getSourceBranch());
        codeReviewEntity.setTargetBranch(codeReviewRequest.getTargetBranch());
        codeReviewEntity.setAuthor(codeReviewRequest.getAuthor());
        codeReviewEntity.setReviewers(codeReviewRequest.getReviewers());
        return codeReviewEntity;
    }
}

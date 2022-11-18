package com.infobip.interviewdemo.service;

import com.infobip.interviewdemo.domain.CommentEntity;
import com.infobip.interviewdemo.domain.CommentType;
import com.infobip.interviewdemo.dto.CommentRequest;
import com.infobip.interviewdemo.repository.CodeReviewRepository;
import com.infobip.interviewdemo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CodeReviewRepository codeReviewRepository;
    private final AnalyticsService analyticsService;

    public String createComment(CommentRequest request){
        var entity = new CommentEntity();
        entity.setCodeReview(codeReviewRepository.findById(request.getCodeReviewId()).orElseThrow());
        entity.setContent(request.getContent());
        entity.setAuthor(request.getAuthor());
        entity.setPosition(request.getPosition());
        entity.setCreatedAt(Instant.ofEpochMilli(request.getCreatedAt()));
        entity.setUpdatedAt(Instant.ofEpochMilli(request.getUpdatedAt()));
        entity.setResolvedAt(Instant.ofEpochMilli(request.getResolvedAt()));
        if (request.getIsTask()) {
            entity.setType(CommentType.TASK);
        } else {
            entity.setType(CommentType.COMMENT);
        }

        commentRepository.save(entity);

        try {
            analyticsService.recordCreateAction(request.getAuthor());
        } catch (Exception e){
            log.error("Failed to store analytics data");
        }

        return String.valueOf(entity.getId());
    }

    public CommentEntity getComment(String commentId){
        var id = Long.valueOf(commentId);
        return commentRepository.findById(id).orElseThrow();
    }
}

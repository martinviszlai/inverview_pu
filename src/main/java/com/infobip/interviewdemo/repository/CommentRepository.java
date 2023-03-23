package com.infobip.interviewdemo.repository;

import com.infobip.interviewdemo.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

    Long countAllByCodeReview_Id(Long codeReviewId);
}

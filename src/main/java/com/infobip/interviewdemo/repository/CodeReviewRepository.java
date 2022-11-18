package com.infobip.interviewdemo.repository;

import com.infobip.interviewdemo.domain.CodeReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface CodeReviewRepository extends CrudRepository<CodeReviewEntity, Long> {
}

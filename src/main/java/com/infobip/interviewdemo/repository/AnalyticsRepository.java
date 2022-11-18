package com.infobip.interviewdemo.repository;

import com.infobip.interviewdemo.domain.AnalyticsData;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnalyticsRepository extends CrudRepository<AnalyticsData, UUID> {
}

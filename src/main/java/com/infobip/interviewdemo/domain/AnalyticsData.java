package com.infobip.interviewdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * Simplification for interview demo project. Please ignore that such analytics would have zero-to-none business value,
 * let's just pretend that these fields are sufficient.
 */
@Entity
@Getter
@Setter
@Table(name = "analytics")
public class AnalyticsData {

    @Id
    @GeneratedValue
    private UUID id;

    private String action;
    private Instant timestamp;
    private String author;
}

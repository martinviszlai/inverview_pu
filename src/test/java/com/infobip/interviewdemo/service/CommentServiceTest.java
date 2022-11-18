package com.infobip.interviewdemo.service;

import com.infobip.interviewdemo.domain.CodeReviewEntity;
import com.infobip.interviewdemo.dto.CommentRequest;
import com.infobip.interviewdemo.repository.CodeReviewRepository;
import com.infobip.interviewdemo.repository.CommentRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest implements WithAssertions {

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private CodeReviewRepository codeReviewRepository;

    @Mock
    private AnalyticsService analyticsService;

    @InjectMocks
    private CommentService underTest;

    @BeforeEach
    void init(){
        var codeReviewEntity = new CodeReviewEntity();
        
    }

    @Test
    void createComment() {
        when(commentRepository.save(ArgumentMatchers.any())).thenReturn(null);
        doNothing().when(analyticsService).recordCreateAction(anyString());

        var commentRequest = CommentRequest.builder()
                .createdAt(Instant.now().toEpochMilli())
                .updatedAt(Instant.now().toEpochMilli())
                .resolvedAt(Instant.now().toEpochMilli())
                .author("Samwise.Gamgee@shire.com")
                .content("Some comment for test")
                .position("Some position in code")
                .isTask(true)
                .build();

        var savedComment = underTest.createComment(commentRequest);

        assertThat(savedComment).isNotNull();

        verify(commentRepository).save(any());
        verify(analyticsService).recordCreateAction(anyString());
    }

    @Test
    void createComment2() {
        when(commentRepository.save(ArgumentMatchers.any())).thenReturn(null);
        doThrow(new RuntimeException("Exception from test")).when(analyticsService).recordCreateAction(anyString());

        var commentRequest = CommentRequest.builder()
                .createdAt(Instant.now().toEpochMilli())
                .updatedAt(Instant.now().toEpochMilli())
                .resolvedAt(Instant.now().toEpochMilli())
                .author("Samwise.Gamgee@shire.com")
                .content("Some comment for test")
                .position("Some position in code")
                .isTask(true)
                .build();

        var savedComment = underTest.createComment(commentRequest);

        assertThat(savedComment).isNotNull();

        verify(commentRepository).save(any());
        verify(analyticsService).recordCreateAction(anyString());
    }

    @Test
    void createComment3() {
        when(commentRepository.save(ArgumentMatchers.any())).thenReturn(null);
        doThrow(new RuntimeException("Exception from test")).when(analyticsService).recordCreateAction(anyString());

        var commentRequest = CommentRequest.builder()
                .createdAt(Instant.now().toEpochMilli())
                .updatedAt(Instant.now().toEpochMilli())
                .resolvedAt(Instant.now().toEpochMilli())
                .author("Samwise.Gamgee@shire.com")
                .content("Some comment for test")
                .position("Some position in code")
                .isTask(true)
                .build();

        var savedComment = underTest.createComment(commentRequest);

        assertThat(savedComment).isNotNull();

        verify(commentRepository).save(any());
        verify(analyticsService).recordCreateAction(anyString());
    }
}
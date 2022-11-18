package com.infobip.interviewdemo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infobip.interviewdemo.InterviewDemoApplication;
import com.infobip.interviewdemo.domain.CodeReviewEntity;
import com.infobip.interviewdemo.dto.CommentRequest;
import com.infobip.interviewdemo.repository.CodeReviewRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {InterviewDemoApplication.class})
@WebAppConfiguration
class CrudControllerTest implements WithAssertions {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CodeReviewRepository codeReviewRepository;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void shouldCreateComment() throws Exception {
        var codeReview = createCodeReview();

        var commentRequest = CommentRequest.builder()
                .codeReviewId(codeReview.getId())
                .createdAt(Instant.now().toEpochMilli())
                .updatedAt(Instant.now().toEpochMilli())
                .resolvedAt(Instant.now().toEpochMilli())
                .author("Samwise.Gamgee@shire.com")
                .content("Some comment for test")
                .position("Some position in code")
                .isTask(true)
                .build();


        var mvcResult = this.mockMvc.perform(post("/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(commentRequest)))
                .andExpect(status().isCreated())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
    }

    private CodeReviewEntity createCodeReview() {
        var codeReview = new CodeReviewEntity();
        codeReview.setId(1L);
        codeReviewRepository.save(codeReview);
        return codeReview;
    }

}
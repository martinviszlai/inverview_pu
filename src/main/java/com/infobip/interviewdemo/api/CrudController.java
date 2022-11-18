package com.infobip.interviewdemo.api;

import com.infobip.interviewdemo.domain.CommentEntity;
import com.infobip.interviewdemo.dto.CommentRequest;
import com.infobip.interviewdemo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CrudController {

    private final CommentService commentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment(@RequestBody CommentRequest commentRequest){
        return commentService.createComment(commentRequest);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CommentEntity getComment(@RequestParam String commentId){
        return commentService.getComment(commentId);
    }

    // TODO other operations
}

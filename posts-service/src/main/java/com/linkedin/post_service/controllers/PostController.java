package com.linkedin.post_service.controllers;

import com.linkedin.post_service.dto.PostCreateRequestDto;
import com.linkedin.post_service.dto.PostDto;
import com.linkedin.post_service.exceptions.ResourceNotFoundException;
import com.linkedin.post_service.services.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postDto,
                                              HttpServletRequest httpServletRequest) {
        log.info("Making a call to Post Service");
        PostDto createdPost = postService.createPost(postDto, 1L);
        log.info("Successfully received a new PostDto, will return the ResponseEntity");
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        PostDto post = postService.getPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}

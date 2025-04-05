package com.linkedin.post_service.services.impl;

import com.linkedin.post_service.dto.PostCreateRequestDto;
import com.linkedin.post_service.dto.PostDto;
import com.linkedin.post_service.entities.Post;
import com.linkedin.post_service.repositories.PostRepository;
import com.linkedin.post_service.services.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostCreateRequestDto postCreateRequestDto, Long userId) {
        log.info("Post creation request from user with userId: {}", userId);
        Post createdPost = modelMapper.map(postCreateRequestDto, Post.class);
        createdPost.setUserId(userId);
        log.info("Trying to save the post...");
        Post savedPost = postRepository.save(createdPost);
        log.info("Post saved with ID: {}", savedPost.getId());
        PostDto savedPostDto = modelMapper.map(savedPost, PostDto.class);
        log.info("Successfully mapped Post to PostDto before returning");
        return savedPostDto;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        return modelMapper.map(post, PostDto.class);
    }
}

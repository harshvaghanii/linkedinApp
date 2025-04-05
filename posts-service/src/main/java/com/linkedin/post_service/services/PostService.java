package com.linkedin.post_service.services;

import com.linkedin.post_service.dto.PostCreateRequestDto;
import com.linkedin.post_service.dto.PostDto;

public interface PostService {
    PostDto createPost(PostCreateRequestDto postCreateRequestDto, Long userId);

    PostDto getPostById(Long postId);
}

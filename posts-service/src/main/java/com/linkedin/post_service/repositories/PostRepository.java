package com.linkedin.post_service.repositories;

import com.linkedin.post_service.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

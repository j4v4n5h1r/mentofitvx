package com.javangar.mentofitvx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javangar.mentofitvx.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

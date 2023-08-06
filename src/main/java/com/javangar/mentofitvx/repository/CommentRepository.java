package com.javangar.mentofitvx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javangar.mentofitvx.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

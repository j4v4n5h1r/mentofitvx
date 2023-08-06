package com.javangar.mentofitvx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javangar.mentofitvx.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

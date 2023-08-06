package com.javangar.mentofitvx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javangar.mentofitvx.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}

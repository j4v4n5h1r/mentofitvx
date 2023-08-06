package com.javangar.mentofitvx.model;

import lombok.Data;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String body;
    
    private String sentAt;
    
    private Long userId;

    public Message() {
    	
    }

	public Message(Long id, String body, String sentAt, Long userId) {
		super();
		this.id = id;
		this.body = body;
		this.sentAt = sentAt;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, id, sentAt, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(body, other.body) && Objects.equals(id, other.id) && Objects.equals(sentAt, other.sentAt)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", body=" + body + ", sentAt=" + sentAt + ", userId=" + userId + "]";
	}

}
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
@Table(name = "save")
public class Save {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    
    private String type;
    
    private Long contentId;

    public Save() {
    	
    }

	public Save(Long id, Long userId, String type, Long contentId) {
		super();
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.contentId = contentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contentId, id, type, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Save other = (Save) obj;
		return Objects.equals(contentId, other.contentId) && Objects.equals(id, other.id)
				&& Objects.equals(type, other.type) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", userId=" + userId + ", type=" + type + ", contentId=" + contentId + "]";
	}
}
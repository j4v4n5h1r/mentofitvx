package com.javangar.mentofitvx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javangar.mentofitvx.model.Comment;
import com.javangar.mentofitvx.repository.CommentRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@PostMapping("/comment")
	public void create(@RequestBody Comment comment) {
		commentRepository.save(comment);
	}
    
    @GetMapping("/comment")
    public ResponseEntity<List<Comment>> findAll(){
    	List<Comment> comments = commentRepository.findAll();
        if (comments == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(comments);
    }
    
	@GetMapping("/comment/{id}")
    public ResponseEntity<Optional<Comment>> findById(@PathVariable("id") int id){
    	if (commentRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(commentRepository.findById((long) id));
    }
}
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

import com.javangar.mentofitvx.model.Post;
import com.javangar.mentofitvx.repository.PostRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostRepository postRepository;

	@PostMapping("/post")
	public void create(@RequestBody Post post) {
		postRepository.save(post);
	}
    
    @GetMapping("/post")
    public ResponseEntity<List<Post>> findAll(){
    	List<Post> posts = postRepository.findAll();
        if (posts == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(posts);
    }
    
	@GetMapping("/post/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable("id") int id){
    	if (postRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(postRepository.findById((long) id));
    }
}
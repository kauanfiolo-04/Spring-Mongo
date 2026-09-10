package com.javacourse_fiolo04.spring_mongo.services;

import com.javacourse_fiolo04.spring_mongo.domain.Post;
import com.javacourse_fiolo04.spring_mongo.domain.User;
import com.javacourse_fiolo04.spring_mongo.dto.UserDTO;
import com.javacourse_fiolo04.spring_mongo.repositories.PostRepository;
import com.javacourse_fiolo04.spring_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}

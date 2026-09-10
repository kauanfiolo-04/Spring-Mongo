package com.javacourse_fiolo04.spring_mongo.resources;

import com.javacourse_fiolo04.spring_mongo.domain.Post;
import com.javacourse_fiolo04.spring_mongo.resources.util.URL;
import com.javacourse_fiolo04.spring_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);

        return ResponseEntity.ok(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(
        @RequestParam(value = "text", defaultValue = "") String text
    ) {
        String textDecoded = URL.decodeParam(text);
        List<Post> list = service.findByTitle(textDecoded);

        return ResponseEntity.ok(list);
    }
}

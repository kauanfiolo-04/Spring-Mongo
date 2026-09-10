package com.javacourse_fiolo04.spring_mongo.config;

import com.javacourse_fiolo04.spring_mongo.domain.Post;
import com.javacourse_fiolo04.spring_mongo.domain.User;
import com.javacourse_fiolo04.spring_mongo.repositories.PostRepository;
import com.javacourse_fiolo04.spring_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 =
            new Post(null, Instant.parse("2018-03-21T19:00:00Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 =
            new Post(null, Instant.parse("2018-03-23T19:00:00Z"), "Bom dia", "Hoje eu acordei feliz!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}

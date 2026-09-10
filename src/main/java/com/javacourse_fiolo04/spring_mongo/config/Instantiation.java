package com.javacourse_fiolo04.spring_mongo.config;

import com.javacourse_fiolo04.spring_mongo.domain.Post;
import com.javacourse_fiolo04.spring_mongo.domain.User;
import com.javacourse_fiolo04.spring_mongo.dto.AuthorDTO;
import com.javacourse_fiolo04.spring_mongo.dto.CommentDTO;
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
        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,
            Instant.parse("2018-03-21T19:00:00Z"),
            "Partiu viagem",
            "Vou viajar para São Paulo. Abraços!",
            new AuthorDTO(maria)
        );
        Post post2 = new Post(null,
            Instant.parse("2018-03-23T19:00:00Z"),
            "Bom dia",
            "Hoje eu acordei feliz!",
            new AuthorDTO(maria)
        );

        CommentDTO c1 = new CommentDTO(
            "Boa viagem mano!",
            Instant.parse("2018-03-21T20:12:56Z"),
            new AuthorDTO(alex)
        );
        CommentDTO c2 = new CommentDTO(
            "Aproveite!",
            Instant.parse("2018-03-22T08:54:34Z"),
            new AuthorDTO(bob)
        );
        CommentDTO c3 = new CommentDTO(
            "Tenha um ótimo dia!",
            Instant.parse("2018-03-23T12:45:50Z"),
            new AuthorDTO(alex)
        );

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);
    }
}

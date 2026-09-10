package com.javacourse_fiolo04.spring_mongo.resources;

import com.javacourse_fiolo04.spring_mongo.domain.User;
import com.javacourse_fiolo04.spring_mongo.dto.UserDTO;
import com.javacourse_fiolo04.spring_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();

        List<UserDTO> listDto =
            list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);

        UserDTO userDto = new UserDTO(user);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
        User user = service.fromDTO(userDto);
        User response = service.insert(user);
        URI uri =
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

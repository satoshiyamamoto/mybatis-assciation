package com.example.java;

import com.example.java.model.Group;
import com.example.java.repository.GroupRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class JavaApplication {

    private final GroupRepository repository;

    public JavaApplication(GroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Group> getGroups() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        Group group = repository.findById(id);
        System.out.println("!!!!!");
        group.getMembers();
        return group;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }
}

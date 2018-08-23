package com.example.demo;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class JavaApplication {

    @Autowired
    private GroupRepository repository;

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

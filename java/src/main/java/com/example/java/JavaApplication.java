package com.example.java;

import com.example.java.model.Team;
import com.example.java.repository.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class JavaApplication {

    private final TeamRepository repository;

    public JavaApplication(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Team> getGroups() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Team getGroup(@PathVariable Long id) {
        Team team = repository.findById(id);
        System.out.println("!!!!!");
        team.getMembers();
        return team;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }
}

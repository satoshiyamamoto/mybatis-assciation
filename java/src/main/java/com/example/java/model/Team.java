package com.example.java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"handler"})
public class Team {

    private Long id;

    private String name;

    private List<Member> members;

    private LocalDateTime createdAt;
}

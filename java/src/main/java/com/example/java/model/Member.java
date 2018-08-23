package com.example.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;

    private String name;

    private Group group;

    private LocalDateTime createdAt;

}

package com.example.java.repository;

import com.example.java.model.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamRepository {

    List<Team> findAll();

    Team findById(@Param("id") Long id);

}

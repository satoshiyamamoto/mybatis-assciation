package com.example.java.repository;

import com.example.java.model.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupRepository {

    List<Group> findAll();

    Group findById(@Param("id") Long id);

}

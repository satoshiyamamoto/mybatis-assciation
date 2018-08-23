package com.example.demo.repository;

import com.example.demo.model.Group;
import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GroupRepository {

    List<Group> findAll();

    Group findById(@Param("id") Long id);

}

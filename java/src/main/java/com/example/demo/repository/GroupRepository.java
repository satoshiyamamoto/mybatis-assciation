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

@Mapper
@Repository
public interface GroupRepository {

    @Select("SELECT * FROM groups")
    List<Group> findAll();

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "members", column = "id", javaType = List.class, many = @Many(fetchType = FetchType.LAZY, select = "com.example.demo.repository.MemberRepository.findByGroupId"))
    })
    @Select("SELECT * FROM groups WHERE id = #{id}")
    Group findById(@Param("id") Long id);

}

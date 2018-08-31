package com.example.java.infrastructure;

import com.example.java.model.Team;
import com.example.java.repository.TeamRepository;
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
public interface TeamMapperRepository extends TeamRepository {

    @Select("SELECT * FROM teams")
    List<Team> findAll();

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "members", column = "id", javaType = List.class, many = @Many(fetchType = FetchType.LAZY, select = "com.example.java.infrastructure.MemberMapperRepository.findByGroupId"))
    })
    @Select("SELECT * FROM teams WHERE id = #{id}")
    Team findById(@Param("id") Long id);

}

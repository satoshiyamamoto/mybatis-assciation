package com.example.demo.repository;

import com.example.demo.model.Group;
import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface MemberRepository {

    @Select("SELECT * FROM members")
    List<Member> findAll();

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "group", column = "group_id", javaType = Group.class, one = @One(fetchType = FetchType.LAZY, select = "com.example.demo.repository.GroupRepository.findById"))
    })
    @Select("SELECT * FROM members WHERE id = #{id}")
    Member findById(@Param("id") Long id);

    @Select("SELECT * FROM members WHERE group_id = #{groupId}")
    List<Member> findByGroupId(@Param("groupId") Long groupId);
}

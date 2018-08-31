package com.example.java.infrastructure;

import com.example.java.model.Team;
import com.example.java.model.Member;
import com.example.java.repository.MemberRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapperRepository extends MemberRepository {

    @Select("SELECT * FROM members")
    List<Member> findAll();

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "team", column = "team_id", javaType = Team.class, one = @One(fetchType = FetchType.LAZY, select = "com.example.java.infrastructure.TeamMapperRepository.findById"))
    })
    @Select("SELECT * FROM members WHERE id = #{id}")
    Member findById(@Param("id") Long id);

    @Select("SELECT * FROM members WHERE team_id = #{groupId}")
    List<Member> findByGroupId(@Param("groupId") Long groupId);
}

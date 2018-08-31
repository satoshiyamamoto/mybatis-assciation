package com.example.kotlin.infrastructure

import com.example.kotlin.model.Member
import com.example.kotlin.model.Team
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.One
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.mapping.FetchType
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface MemberMapperRepository {

    @Select("SELECT * FROM members")
    fun findAll(): MutableList<Member>

    @Results(
        Result(id = true, property = "id", column = "id"),
        Result(property = "team", column = "team_id", javaType = Team::class, one = One(fetchType = FetchType.LAZY, select = "com.example.kotlin.infrastructure.TeamMapperRepository.findById"))
    )
    @Select("SELECT * FROM members WHERE id = #{id}")
    fun findById(id: Long): Member

    @Select("SELECT * FROM members WHERE team_id = #{groupId}")
    fun findByGroupId(groupId: Long): MutableList<Member>
}

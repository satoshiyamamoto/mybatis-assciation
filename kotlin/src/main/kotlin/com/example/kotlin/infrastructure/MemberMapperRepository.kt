package com.example.kotlin.infrastructure

import com.example.kotlin.model.Member
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface MemberMapperRepository {

    @Select("SELECT * FROM members")
    fun findAll(): MutableList<Member>

    @Select("SELECT * FROM members WHERE id = #{id}")
    fun findById(@Param("id") id: Long): Member

    @Select("SELECT * FROM members WHERE group_id = #{groupId}")
    fun findByGroupId(@Param("groupId") groupId: Long): MutableList<Member>
}

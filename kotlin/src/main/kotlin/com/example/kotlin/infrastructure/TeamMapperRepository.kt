package com.example.kotlin.infrastructure

import com.example.kotlin.model.Team
import org.apache.ibatis.annotations.Many
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.mapping.FetchType
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface TeamMapperRepository {

    @Select("SELECT * FROM teams")
    fun findAll(): MutableList<Team>

    @Results(value = [
        Result(id = true, property = "id", column = "id"),
        Result(property = "members", column = "id", javaType = MutableList::class, many = Many(fetchType = FetchType.LAZY, select = "com.example.kotlin.infrastructure.MemberMapperRepository.findByGroupId"))
    ])
    @Select("SELECT * FROM teams WHERE id = #{id}")
    fun findById(id: Long): Team

}

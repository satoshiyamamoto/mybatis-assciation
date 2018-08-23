package com.example.kotlin.infrastructure

import com.example.kotlin.model.Group
import org.apache.ibatis.annotations.*
import org.apache.ibatis.mapping.FetchType
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface GroupMapperRepository {

    @Select("SELECT * FROM groups")
    fun findAll(): MutableList<Group>

    @Results(value = [
        Result(id = true, property = "id", column = "id"),
        Result(property = "members", column = "id", javaType = MutableList::class, many = Many(fetchType = FetchType.LAZY, select = "com.example.kotlin.infrastructure.MemberMapperRepository.findByGroupId"))
    ])
    @Select("SELECT * FROM groups WHERE id = #{id}")
    fun findById(@Param("id") id: Long): Group

}

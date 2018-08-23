package com.example.kotlin.repository

import com.example.kotlin.model.Group
import org.apache.ibatis.annotations.Param

interface GroupRepository {

    fun findAll(): List<Group>

    fun findById(@Param("id") id: Long): Group

}

package com.example.kotlin.repository

import com.example.kotlin.model.Member
import org.apache.ibatis.annotations.Param

interface MemberRepository {

    fun findAll(): List<Member>

    fun findById(@Param("id") id: Long?): Member

    fun findByGroupId(@Param("groupId") groupId: Long): List<Member>
}

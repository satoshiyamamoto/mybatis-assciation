package com.example.kotlin.repository

import com.example.kotlin.model.Member

interface MemberRepository {

    fun findAll(): List<Member>

    fun findById(id: Long?): Member

    fun findByGroupId(groupId: Long): List<Member>
}

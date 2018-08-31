package com.example.kotlin.repository

import com.example.kotlin.model.Team

interface TeamRepository {

    fun findAll(): List<Team>

    fun findById(id: Long): Team
}

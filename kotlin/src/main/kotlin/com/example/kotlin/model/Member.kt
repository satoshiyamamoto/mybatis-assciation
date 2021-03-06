package com.example.kotlin.model

import java.time.LocalDateTime

@Entity
data class Member(
        var id: Long = 0,
        var name: String = "",
        var team: Team? = null,
        var createdAt: LocalDateTime = LocalDateTime.now()
)

package com.example.kotlin.model

import java.time.LocalDateTime

@Entity
data class Team(
        var id: Long = 0,
        var name: String = "",
        var members: MutableList<Member> = mutableListOf(),
        var createdAt: LocalDateTime = LocalDateTime.now()
)

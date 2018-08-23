package com.example.kotlin.model

import java.time.LocalDateTime

open class Group(
        var id: Long,
        var name: String,
        var members: MutableList<Member>,
        var createdAt: LocalDateTime
) {

    constructor() :
            this(0, "", mutableListOf(), LocalDateTime.now())
}

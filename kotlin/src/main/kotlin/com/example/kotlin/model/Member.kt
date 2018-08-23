package com.example.kotlin.model

import java.time.LocalDateTime

open class Member(
        var id: Long,
        var name: String,
        var group: Group?,
        var createdAt: LocalDateTime
) {

    constructor() :
            this(0, "", null, LocalDateTime.now())
}

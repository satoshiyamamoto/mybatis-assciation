package com.example.kotlin.infrastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class TeamMapperRepositoryTest {

    @Autowired
    lateinit var repository: TeamMapperRepository

    @Test
    fun should_load_repository() {
        assertThat(repository).isNotNull
    }

    @Test
    fun should_returns_all_group() {
        assertThat(repository.findAll()).hasSize(2)
    }

    @Test
    fun should_returns_a_group() {
        val group = repository.findById(1L)
        assertThat(group).isNotNull
        assertThat(group.id).isEqualTo(1L)
        assertThat(group.name).isEqualTo("BAND-MAID")
        assertThat(group.members).hasSize(5)
        assertThat(group.createdAt).isBeforeOrEqualTo(LocalDateTime.now())
    }
}

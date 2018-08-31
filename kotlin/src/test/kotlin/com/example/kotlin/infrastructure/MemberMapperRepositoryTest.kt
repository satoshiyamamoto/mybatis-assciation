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
class MemberMapperRepositoryTest {

    @Autowired
    lateinit var repository: MemberMapperRepository

    @Test
    fun should_load_repository() {
        assertThat(repository).isNotNull
    }

    @Test
    fun should_returns_all_members() {
        assertThat(repository.findAll()).hasSize(9)
    }

    @Test
    fun should_returns_members_with_band_maid() {
        assertThat(repository.findByGroupId(1L)).hasSize(5)
    }

    @Test
    fun should_returns_a_member() {
        val member = repository.findById(1L)
        assertThat(member).isNotNull
        assertThat(member.id).isEqualTo(1L)
        assertThat(member.name).isEqualTo("Saiki")
        assertThat(member.team).isNotNull
        assertThat(member.team?.name).isEqualTo("BAND-MAID")
        assertThat(member.createdAt).isBeforeOrEqualTo(LocalDateTime.now())
    }
}

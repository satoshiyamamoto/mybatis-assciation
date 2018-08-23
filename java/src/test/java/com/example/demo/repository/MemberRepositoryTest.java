package com.example.demo.repository;

import com.example.demo.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    public void should_load_repository() {
        assertThat(repository).isNotNull();
    }

    @Test
    public void should_returns_all_members() {
        assertThat(repository.findAll()).hasSize(9);
    }

    @Test
    public void should_returns_members_with_band_maid() {
        assertThat(repository.findByGroupId(1L)).hasSize(5);
    }

    @Test
    public void should_returns_a_member() {
        Member member = repository.findById(1L);
        assertThat(member).isNotNull();
        assertThat(member.getId()).isEqualTo(1L);
        assertThat(member.getName()).isEqualTo("Saiki");
        assertThat(member.getGroup()).isNotNull();
        assertThat(member.getGroup().getName()).isEqualTo("BAND-MAID");
        assertThat(member.getCreatedAt()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}

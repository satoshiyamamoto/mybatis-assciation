package com.example.java.infrastructure;

import com.example.java.model.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamMapperRepositoryTest {

    @Autowired
    private TeamMapperRepository repository;

    @Test
    public void should_load_repository() {
        assertThat(repository).isNotNull();
    }

    @Test
    public void should_returns_all_group() {
        assertThat(repository.findAll()).hasSize(2);
    }

    @Test
    public void should_returns_a_group() {
        Team team = repository.findById(1L);
        assertThat(team).isNotNull();
        assertThat(team.getId()).isEqualTo(1L);
        assertThat(team.getName()).isEqualTo("BAND-MAID");
        assertThat(team.getMembers()).hasSize(5);
        assertThat(team.getCreatedAt()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}

package com.example.java.infrastructure;

import com.example.java.infrastructure.GroupMapperRepository;
import com.example.java.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GroupMapperRepositoryTest {

    @Autowired
    private GroupMapperRepository repository;

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
        Group group = repository.findById(1L);
        assertThat(group).isNotNull();
        assertThat(group.getId()).isEqualTo(1L);
        log.info("=== {} ===", "lazy loading...");
        assertThat(group.getName()).isEqualTo("BAND-MAID");
        assertThat(group.getMembers()).hasSize(5);
        assertThat(group.getCreatedAt()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}

package com.example.java.repository;

import com.example.java.model.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberRepository {

    List<Member> findAll();

    Member findById(@Param("id") Long id);

    List<Member> findByGroupId(@Param("groupId") Long groupId);
}

package com.example.demo.repository;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberRepository {

    List<Member> findAll();

    Member findById(@Param("id") Long id);

    List<Member> findByGroupId(@Param("groupId") Long groupId);
}

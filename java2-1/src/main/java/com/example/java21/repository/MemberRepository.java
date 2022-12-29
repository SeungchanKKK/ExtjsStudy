package com.example.java21.repository;

import com.example.java21.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findAllByMemberNickContaining(String searchValue);

    List<Member> findAllByMemberNmContaining (String searchValue);
}

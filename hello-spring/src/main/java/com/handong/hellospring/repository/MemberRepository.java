package com.handong.hellospring.repository;

import com.handong.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //NULL 를 처리하기 위한 새로운 방법
    Optional<Member> findByName(String name);
    List<Member> findAll(); //모든 리스트 반환

}

package com.handong.hellospring.service;

import com.handong.hellospring.domain.Member;
import com.handong.hellospring.repository.MemberRepository;
import com.handong.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {//command + sift + T 하면 테스트가 알아서 생
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { // memberRepository를 외부에서 넣어준다. 이것은 DI, 디펜던스 이젝티브..?라고한다.
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 x
        vaildateDuplicateMember(member);// 중복 회원 검사 contorl + T 하고 method extract 하면 메소드가 알아서 만들어짐
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
             throw new IllegalStateException("이미 존재 하는 회원입니다.");
         } );
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

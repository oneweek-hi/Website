package com.handong.hellospring.service;

import com.handong.hellospring.domain.Member;
import com.handong.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // new를 사용해서 같은 객체가 아니다..!
    MemoryMemberRepository memberRepository; //그래서 class에서 컨스트럭터를 만들어서 외부에서 repository를 넣어주게 한다.
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() { //test는 이렇게 정상적인 상황에서 잘되는 것도 중요햐지만, 결국 제일 중요한 것은 예외 상황일 때 어떻게 해결하나 이다!
        //뭔가가 주어졌을때 이거를 실행 했을때 결과가가 이렇게 나와야 한다!
        //give
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then 우리가 저장한게 repository에 있는게 맞아?을 알려고 하는 것
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재 하는 회원입니다.");
        }


        //then



    }


    @Test
    void findMembers() {
    }

    @Test
    void finOne() {
    }
}
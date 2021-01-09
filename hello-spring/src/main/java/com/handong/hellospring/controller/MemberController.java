package com.handong.hellospring.controller;

import com.handong.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //  관리하고 있기 때문에 딱히 new로 만들어줄 필요가 없다.
    //스프링 컨터이너에 등록해놓고 하나만 쓰면 된다.

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

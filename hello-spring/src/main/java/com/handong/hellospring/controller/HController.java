package com.handong.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "qkdhqkdhqkdhqkh");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  //http에서 HEAD와 body가 있는데 body에 직접 이값을 넣겠다는 것이다.
    public String HelloString(@RequestParam("name") String name){
        return "hello " + name; //view 이런게 없고 그냥 요청 한 값이 그대로 내려감!
    }
    //만약 데이터를 달라고 할 경우
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ //제이슨 방식
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

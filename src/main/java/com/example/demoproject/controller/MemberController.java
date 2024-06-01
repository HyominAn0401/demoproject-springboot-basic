package com.example.demoproject.controller;

import com.example.demoproject.dto.MemberFormDTO;
import com.example.demoproject.entity.MemberEntity;
import com.example.demoproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUp(){
        return "new";
    }
    @PostMapping("/join")
    public String toSignUp(MemberFormDTO memberFormDTO){
        //1. DTO -> Entity
        MemberEntity memberEntity = memberFormDTO.toEntity();
        //2. Repository를 이용해 Entity를 DB에 저장
        MemberEntity saved = memberRepository.save(memberEntity);
        return "";
    }

}

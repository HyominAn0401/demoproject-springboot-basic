package com.example.demoproject.controller;

import com.example.demoproject.dto.MemberFormDTO;
import com.example.demoproject.entity.MemberEntity;
import com.example.demoproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUp(){
        return "members/new2";
    }

    @PostMapping("/join")
    public String toSignUp(MemberFormDTO memberFormDTO){
        log.info(memberFormDTO.toString());
        //1. DTO -> Entity
        MemberEntity memberEntity = memberFormDTO.toEntity();
        log.info(memberEntity.toString());
        //2. Repository를 이용해 Entity를 DB에 저장
        MemberEntity saved = memberRepository.save(memberEntity);
        log.info(saved.toString());
        return "";
    }

}

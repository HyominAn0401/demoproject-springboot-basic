package com.example.demoproject.controller;

import com.example.demoproject.dto.MemberFormDTO;
import com.example.demoproject.entity.MemberEntity;
import com.example.demoproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        return "redirect:/members/"+ saved.getId();
    }

    @GetMapping("members/{id}")
    public String show(@PathVariable Long id, Model model){
        //1. ID로 DB에서 데이터
        MemberEntity member = memberRepository.findById(id).orElse(null);
        //2. model에 data 등록
        model.addAttribute("memberEntity", member);
        //3. view templates 반환
        return "members/show2";
    }

    @GetMapping("/members")
    public String index(Model model){
        List<MemberEntity> memberEntities = (List<MemberEntity>)memberRepository.findAll();
        model.addAttribute("memberEntityList", memberEntities);
        return "members/index2";
    }

}

package com.example.demoproject.dto;

import com.example.demoproject.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@ToString
public class MemberFormDTO {

    private String email;
    private String password;

//    public MemberFormDTO(String email, String password){
//        this.email = email;
//        this.password = password;
//    }

    public MemberEntity toEntity(){
        return new MemberEntity(null, email, password);
    }
}

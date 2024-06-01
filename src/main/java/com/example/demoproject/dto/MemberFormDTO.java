package com.example.demoproject.dto;

import com.example.demoproject.entity.MemberEntity;

public class MemberFormDTO {

    private String email;
    private String password;

    public MemberFormDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

    public MemberEntity toEntity(){
        return new MemberEntity(null, email, password);
    }
}

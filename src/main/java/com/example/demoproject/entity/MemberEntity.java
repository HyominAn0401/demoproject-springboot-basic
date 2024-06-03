package com.example.demoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Entity
public class MemberEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;
    @Column
    private String password;

//    public MemberEntity(Long id, String email, String password){
//        this.id = id;
//        this.email = email;
//        this.password = password;
//    }
}

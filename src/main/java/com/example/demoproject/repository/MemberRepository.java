package com.example.demoproject.repository;

import com.example.demoproject.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

}

package com.bitcamp.web.repositories;

import java.util.Optional;

import com.bitcamp.web.entities.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * MemberRepository
 */
@Repository
public interface MemberRepository  extends CrudRepository<Member,Long>{
    
    public Optional<Member> findByEmailAndPassword(String email, String password);
    public Member findByEmail(String email);
}
package com.bitcamp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.bitcamp.web.common.lambda.ISupplier;
import com.bitcamp.web.domain.MemberDTO;
import com.bitcamp.web.entities.Member;
import com.bitcamp.web.repositories.MemberRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MemberController
 */
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired MemberDTO        member;
    @Autowired ModelMapper      modelMapper;
    @Autowired MemberRepository repo;
    
    @Bean
    public ModelMapper ModelMapper(){
        return new ModelMapper();
    }

    //카운트
    @GetMapping("/count")
    public long count(){
        System.out.println("=========================MemberController.count()");  
        ISupplier fx = ()->{
            return repo.count();            
        };
        return (long)fx.get();
    }

    //회원가입
    @PostMapping("")
    public HashMap<String,String> save(@RequestBody MemberDTO dto){
        System.out.println("=========================MemberController.save()");
        
        HashMap<String,String> map = new HashMap<>();
        Member entity              = new Member();
        
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());  
        entity.setGrade(dto.getGrade());
        entity.setIntroduce(dto.getIntroduce());
        
        try {
            repo.save(entity);
            map.put("result","회원가입 성공! 로그인해주세요");  
        } catch (Exception e) {
            map.put("result","중복된 아이디 입니다.");  
        }
        return map;   
    }

    //로그인(기본로그인 완료) 
    @PostMapping("/login")
    public MemberDTO login(@RequestBody MemberDTO dto){
        System.out.println("=========================MemberController.login()");
        ISupplier fx = ()->{
            return repo.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(EntityNotFoundException::new);
        };
        return modelMapper.map(fx.get(),MemberDTO.class);
    }

    //회원관리 페이지
    @GetMapping("/memberList")
    public Iterable<MemberDTO>	findAll(){
        System.out.println("=========================MemberController.findAll()");
        
        Iterable<Member> entities = repo.findAll();
        List<MemberDTO> list      = new ArrayList<>();
        
        for(Member m: entities){
            MemberDTO mem = modelMapper.map(m, MemberDTO.class);
            list.add(mem);
        }
        
        return list; 
    }

    //회원탈퇴
    @DeleteMapping("{id}")
    public HashMap<String,Object>	deleteById(@PathVariable String id){
        System.out.println("=========================MemberController.deleteById()");
        
        HashMap<String,Object> map = new HashMap<>();
        //삭제
        repo.deleteById(Long.parseLong(id));
       
        Iterable<Member> entities = repo.findAll();
        List<MemberDTO> list      = new ArrayList<>();
        
        for(Member m : entities){
            MemberDTO mem = modelMapper.map(m, MemberDTO.class);
            list.add(mem);
        }
        
        map.put("result","탈퇴되셨습니다.");
        map.put("list",list);
        
        return map;
    }

    //마이페이지 수정 + 비밀번호 수정
    @PostMapping("/updateMypage")
    public HashMap<String,String>	updateMypage(@RequestBody MemberDTO dto){
        System.out.println("=========================MemberController.updateMypage()");
        
        //dto를 엔티티로 바꿈
        //바뀌기 전 원래거를 찾아오는것
        Member entity = repo.findById(Long.parseLong(dto.getId())).orElseThrow(EntityNotFoundException::new);
        
        //바뀐정보만 재세팅
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setIntroduce(dto.getIntroduce());
       
        //저장
        repo.save(entity); 
        
        HashMap<String,String> map = new HashMap<>();
        map.put("result","수정성공");
        return map;   
    }
}
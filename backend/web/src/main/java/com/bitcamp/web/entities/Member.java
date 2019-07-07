package com.bitcamp.web.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
/**
 * Member
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@ToString
@Table(name = "members")
public class Member implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="id") private Long id;
    @Column(name="name") private String	name;
    @Column(name="email") private String email;
    @Column(name="password") private String	password ;
    @Column(name="grade") private String grade;
    @Column(name="introduce") private String introduce;

    @Override
    public String toString(){
        return "Member :[id:"+id+",name:" +name+", email:"+email+", password:"+password+", grade:"+grade+
       ", introduce:"+introduce+"]";
    }

    @Builder
    private Member(String name,String email,
    String password,String grade,String introduce){
        this.name      = name;
        this.email     = email;
        this.password  = password;
        this.grade     = grade;
        this.introduce = introduce;
    }
}
package com.example.jpaexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor     //생성자 자동 생성
@NoArgsConstructor      //파라미터가 없는 생성자 생성
@Entity(name="member") //table name
public class Member {



    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//seq처럼 자동증가
    private Long id;

    private String username;

    private String password;



}

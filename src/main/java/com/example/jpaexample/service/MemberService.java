package com.example.jpaexample.service;

import com.example.jpaexample.model.Member;
import com.example.jpaexample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //생성자 자동 주입
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public List<Member> getUserOne(String username) {
        return memberRepository.findByUsername(username);

    }

    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }


}

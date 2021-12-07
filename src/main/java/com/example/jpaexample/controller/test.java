package com.example.jpaexample.controller;


import com.example.jpaexample.model.Member;
import com.example.jpaexample.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class test {

    private final MemberService memberService;

    @GetMapping("/getAllMembers")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> member = memberService.findAll();
        return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
    }

    @GetMapping("/findMember")
    public ResponseEntity<List<Member>> getMember(String username) {
        List<Member> member = memberService.getUserOne(username);
        return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Member> save(Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveMember", method = RequestMethod.GET)
    public ResponseEntity<Member> save(HttpServletRequest req, Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }


    @GetMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("data", "hello!");
        return "test1";
    }


}

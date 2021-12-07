package com.example.jpaexample.repository;

import com.example.jpaexample.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
@RepositoryRestResource(path = "members")
public interface MemberRepository extends JpaRepository<Member,Long> {

    public List<Member> findByUsername(String username);

}

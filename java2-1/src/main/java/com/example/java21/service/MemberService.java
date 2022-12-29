package com.example.java21.service;

import com.example.java21.dto.MemberReadDto;
import com.example.java21.model.Member;
import com.example.java21.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> readmembers(MemberReadDto dto) {
        if(dto.getSearchCode()==null){
            return memberRepository.findAll();}
        else {
            if(dto.getSearchCode().equals("memberNm")){
             return memberRepository.findAllByMemberNmContaining(dto.getSearchValue());
            }else {
            return memberRepository.findAllByMemberNickContaining(dto.getSearchValue());}
        }
    }

    public void addmember(Member member) {
        Member member1 = new Member(member.getMemberNm(), member.getAddress(), member.getMemberNick());
        memberRepository.save(member1);
    }
}

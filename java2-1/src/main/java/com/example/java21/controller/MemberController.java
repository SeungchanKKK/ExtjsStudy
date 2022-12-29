package com.example.java21.controller;

import com.example.java21.dto.MemberReadDto;
import com.example.java21.dto.ProductReadDto;
import com.example.java21.model.Member;
import com.example.java21.model.Product;
import com.example.java21.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/")
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/list/member")
    public Map<String,Object> readmembers(MemberReadDto dto){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Member> data = memberService.readmembers(dto);
        result.put("code",200);
        result.put("totalCount",data.size());
        result.put("data",data);
        return result;
    }

    @PostMapping(value = "/add/member")
    public Map<String,Object> addmember (@RequestBody Member member){
        memberService.addmember(member);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("message","등록완료");
        return  result;
    }
}

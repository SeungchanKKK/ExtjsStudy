package com.example.java21.controller;

import com.example.java21.model.Admin;
import com.example.java21.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @RequestMapping(value = "/loginInfo", method = RequestMethod.POST)
    public Map<String,Object> loginInfo(Admin parm, HttpServletRequest request) {
        Map<String,Object> result = loginService.loginInfo(parm);
        if(result.get("관리자닉네임")==null){
            result.put("code",404);
            result.put("errmsg","틀렸습니다");
        }else {
            result.put("code", 200);
            request.getSession().setAttribute("admin",result);
        }
        return result;
    }

    @RequestMapping(value = "/adminadd")
    public String adminadd(){
        loginService.adminadd();
        return "임시데이터저장";
    }

    @RequestMapping(value = "/fail")
    public Map<String,Object> fail(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code", 999);
        return result;
    }
}

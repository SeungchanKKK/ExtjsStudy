package com.example.java21.service;

import com.example.java21.model.Admin;
import com.example.java21.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public Map<String, Object> loginInfo(Admin parm) {
        Admin admin = loginRepository.findAdminByAdminNicknameAndAdminPwd(parm.getAdminNickname(), parm.getAdminPwd());
        System.out.println(admin);
        Map<String, Object> result = new HashMap<String, Object>();
        if(admin==null){
            result.put("관리자닉네임", null);
            result.put("관리자아이디", null);
            return result;
        }else {
            result.put("관리자닉네임", admin.getAdminNm());
            result.put("관리자아이디", admin.getAdminNickname());
            return  result;
        }
    }

    public void adminadd() {
        if(loginRepository.existsAdminByAdminNickname("admin")){
        }else {
        Admin admin = new Admin("admin","1234","임시관리자");
        loginRepository.save(admin);}
    }
}

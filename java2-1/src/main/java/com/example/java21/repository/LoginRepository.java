package com.example.java21.repository;

import com.example.java21.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Admin,Long> {
    Admin findAdminByAdminNicknameAndAdminPwd(String adminNickname, String adminPwd);

    Boolean existsAdminByAdminNickname(String adminNickname);
}

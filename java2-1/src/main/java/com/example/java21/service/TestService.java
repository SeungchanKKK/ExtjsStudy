package com.example.java21.service;

import com.example.java21.model.Test;
import com.example.java21.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;

    public List<Test> getList() throws SQLException {
        List<Test> lists = testRepository.findAll();
        return lists;
    }

    public String createList() {
        Test list = new Test("테스트","벨류");
        testRepository.save(list);
        return "작성되었습니다";
    }
}

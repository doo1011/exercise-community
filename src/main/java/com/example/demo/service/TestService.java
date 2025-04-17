package com.example.demo.service;

import com.example.demo.dto.TestDto;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepo;

    public List<TestDto> getData() {
        return testRepo.getData();
    }
}

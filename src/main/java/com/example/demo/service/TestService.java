package com.example.demo.service;

import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepo;

    public void printData() {
        testRepo.printData();
    }
}

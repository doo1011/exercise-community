package com.example.demo.controller;

import com.example.demo.dto.TestDto;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/test")
    public ResponseEntity<List<TestDto>> getTest() {
        return ResponseEntity.ok(testService.getData());
    }
}

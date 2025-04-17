package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestDto {
    private Long id;
    private String title;
    private String author;
    private String contents;
}

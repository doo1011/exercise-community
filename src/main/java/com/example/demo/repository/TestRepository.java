package com.example.demo.repository;

import com.example.demo.dto.TestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestRepository {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    public List<TestDto> getData() {
        List<TestDto> result = new ArrayList<>();
        // try-with-resources 구문 사용
        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            // insert는 별도 블록으로 작성 가능
//            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name) VALUES (?)")) {
//                pstmt.setString(1, "Bob");
//                pstmt.executeUpdate();
//            }

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM board")) {
                while (rs.next()) {
                    result.add(TestDto.builder()
                                    .id(rs.getLong("id"))
                                    .title(rs.getString("title"))
                                    .author(rs.getString("author"))
                                    .contents(rs.getString("contents"))
                            .build());}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

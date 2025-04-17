package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class TestRepository {
    String url = "jdbc:h2:./data/testdb";
    String user = "kdhur";
    String password = "kdhur";

    public void printData() {
        // try-with-resources 구문 사용
        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            // insert는 별도 블록으로 작성 가능
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name) VALUES (?)")) {
                pstmt.setString(1, "Bob");
                pstmt.executeUpdate();
            }

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
                while (rs.next()) {
                    System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

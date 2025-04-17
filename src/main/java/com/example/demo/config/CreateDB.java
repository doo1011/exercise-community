package com.example.demo.config;

import java.sql.*;

public class CreateDB {
    public static void main(String[] args) {
        String url = "jdbc:h2:./data/testdb";  // 현재 폴더에 생성
        String user = "kdhur";
        String password = "kdhur";

        try {
            // DB 연결
            Connection conn = DriverManager.getConnection(url, user, password);

            // 테이블 생성
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS test (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))");

            // 데이터 삽입
            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO test (name) VALUES (?)");
            insertStmt.setString(1, "Alice");
            insertStmt.executeUpdate();

            // 데이터 조회
            ResultSet rs = stmt.executeQuery("SELECT * FROM test");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name"));
            }

            // 자원 정리
            rs.close();
            insertStmt.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

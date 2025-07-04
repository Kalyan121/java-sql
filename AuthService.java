package com.secureapp;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    public boolean register(String username, String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, hashed);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Register error: " + e.getMessage());
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT password FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");
                return BCrypt.checkpw(password, storedHash);
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return false;
    }
}

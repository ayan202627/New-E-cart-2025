package com.jwt.auth_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class User {
    @Id
    private String emailid;
    private String name, password, role, status;

    public User() {
    }

    public User(String emailid, String name, String password, String role, String status) {
        this.emailid = emailid;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailid='" + emailid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return emailid.equals(user.emailid) && name.equals(user.name) && password.equals(user.password) && role.equals(user.role) && status.equals(user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailid, name, password, role, status);
    }
}

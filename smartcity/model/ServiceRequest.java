package com.smartcity.model;

import java.time.LocalDateTime;

public class ServiceRequest {

    private int id;
    private String username;
    private RequestType type;
    private RequestStatus status;
    private String description;
    private LocalDateTime createdAt;

    // ---- GETTERS & SETTERS ----

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {          // REQUIRED
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public RequestType getType() {
        return type;
    }
    public void setType(RequestType type) {
        this.type = type;
    }

    public RequestStatus getStatus() {
        return status;
    }
    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ---- To String for printing ----
    @Override
    public String toString() {
        return "Request ID: " + id +
               " | User: " + username +
               " | Type: " + type +
               " | Status: " + status +
               " | Description: " + description +
               " | Created: " + createdAt;
    }
}
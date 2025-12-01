package com.smartcity.service;

import com.smartcity.dao.RequestDAO;
import com.smartcity.model.ServiceRequest;
import com.smartcity.model.RequestType;
import com.smartcity.model.RequestStatus;

import java.time.LocalDateTime;
import java.util.List;

public class RequestService {

    private RequestDAO requestDAO = new RequestDAO();

    public void submitRequest(String username, RequestType type, String description) {

        ServiceRequest req = new ServiceRequest();

        // DAO will assign ID
        req.setUsername(username);
        req.setType(type);
        req.setDescription(description);
        req.setStatus(RequestStatus.PENDING);
        req.setCreatedAt(LocalDateTime.now());

        requestDAO.save(req);
    }

    public List<ServiceRequest> getUserRequests(String username) {
        return requestDAO.findByUser(username);
    }

    public List<ServiceRequest> getAllRequests() {
        return requestDAO.findAll();
    }

    public void updateStatus(int id, RequestStatus status) {
        ServiceRequest req = requestDAO.findById(id);
        if (req != null) {
            req.setStatus(status);
            requestDAO.save(req); // save updated request
        }
    }
}

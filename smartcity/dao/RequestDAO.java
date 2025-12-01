package com.smartcity.dao;

import com.smartcity.model.ServiceRequest;
import java.util.*;

public class RequestDAO {

    private Map<Integer, ServiceRequest> requestMap = new LinkedHashMap<>();

    // Auto-increment counter
    private static int counter = 1;

    // Save or update
    public void save(ServiceRequest request) {
        if (request.getId() == 0) {
            request.setId(counter++); // Assign new unique ID
        }
        requestMap.put(request.getId(), request);
        saveToFile();  // if you have file persistence
    }

    public ServiceRequest findById(int id) {
        return requestMap.get(id);
    }

    public List<ServiceRequest> findByUser(String username) {
        List<ServiceRequest> list = new ArrayList<>();
        for (ServiceRequest req : requestMap.values()) {
            if (req.getUsername().equals(username)) {
                list.add(req);
            }
        }
        return list;
    }

    public List<ServiceRequest> findAll() {
        return new ArrayList<>(requestMap.values());
    }

    // Optional for file-based projects:
    private void saveToFile() {
        // If you implemented file-based storage, keep this.
    }
}

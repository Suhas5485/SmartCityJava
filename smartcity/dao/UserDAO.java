package com.smartcity.dao;
import com.smartcity.model.*;
import com.smartcity.util.SerializationUtil;
import java.util.*;


public class UserDAO {


private static final String FILE = "users.ser";
private Map<String, User> users = new HashMap<>();


public UserDAO() {
Object data = SerializationUtil.deserialize(FILE);
if (data != null) users = (Map<String, User>) data;
else {
users.put("admin", new Admin("admin", "admin123"));
}
}


public void save() {
SerializationUtil.serialize(users, FILE);
}


public void addUser(User user) {
users.put(user.getUsername(), user);
save();
}


public User getUser(String username) {
return users.get(username);
}
}
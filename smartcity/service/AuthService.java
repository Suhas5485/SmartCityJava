package com.smartcity.service;
import com.smartcity.dao.UserDAO;
import com.smartcity.exceptions.AuthenticationException;
import com.smartcity.model.User;


public class AuthService {
private UserDAO userDAO = new UserDAO();


public User login(String username, String password) throws AuthenticationException {
User user = userDAO.getUser(username);
if (user == null || !user.getPassword().equals(password))
throw new AuthenticationException("Invalid username or password");
return user;
}


public void registerCitizen(String username, String password, String fullName) {
userDAO.addUser(new com.smartcity.model.Citizen(username, password, fullName));
}
}
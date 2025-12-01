package com.smartcity.app;

import com.smartcity.exceptions.AuthenticationException;
import com.smartcity.model.*;
import com.smartcity.service.*;
import java.util.*;

public class MainApp {

    private static Scanner sc = new Scanner(System.in);
    private static AuthService authService = new AuthService();
    private static RequestService requestService = new RequestService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== SMART CITY SYSTEM =====");
            System.out.println("1. Citizen Login");
            System.out.println("2. Citizen Register");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> citizenLogin();
                case 2 -> registerCitizen();
                case 3 -> adminLogin();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // -------------------- CITIZEN LOGIN --------------------
    private static void citizenLogin() {
        try {
            System.out.print("Enter username: ");
            String u = sc.nextLine();
            System.out.print("Enter password: ");
            String p = sc.nextLine();

            User user = authService.login(u, p);
            if (user instanceof Citizen)
                citizenMenu(user.getUsername());
            else
                System.out.println("Not a citizen account");

        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }

    // -------------------- CITIZEN REGISTER --------------------
    private static void registerCitizen() {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();
        System.out.print("Enter full name: ");
        String f = sc.nextLine();

        authService.registerCitizen(u, p, f);
        System.out.println("Citizen registered successfully!");
    }

    // -------------------- ADMIN LOGIN --------------------
    private static void adminLogin() {
        try {
            System.out.print("Enter username: ");
            String u = sc.nextLine();
            System.out.print("Enter password: ");
            String p = sc.nextLine();

            User user = authService.login(u, p);
            if (user instanceof Admin)
                adminMenu();
            else
                System.out.println("Not an admin account");

        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }

    // -------------------- CITIZEN MENU --------------------
    private static void citizenMenu(String username) {
        while (true) {
            System.out.println("\n----- Citizen Menu -----");
            System.out.println("1. Submit Request");
            System.out.println("2. View My Requests");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> submitReq(username);
                case 2 -> viewMyRequests(username);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // -------------------- SUBMIT REQUEST --------------------
    private static void submitReq(String username) {
        System.out.println("Choose Issue Type:");
        System.out.println("1. Water Issue");
        System.out.println("2. Electricity Issue");
        System.out.println("3. Road Damage");
        System.out.println("4. Other");
        System.out.print("Enter choice: ");

        int t = sc.nextInt();
        sc.nextLine();

        RequestType type = switch (t) {
            case 1 -> RequestType.WATER_ISSUE;
            case 2 -> RequestType.ELECTRICITY_ISSUE;
            case 3 -> RequestType.ROAD_DAMAGE;
            default -> RequestType.OTHER;
        };

        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        requestService.submitRequest(username, type, desc);
        System.out.println("Request submitted successfully!");
    }

    // -------------------- VIEW MY REQUESTS --------------------
    private static void viewMyRequests(String username) {
        List<ServiceRequest> list = requestService.getUserRequests(username);
        list.forEach(System.out::println);
    }

    // -------------------- ADMIN MENU --------------------
    private static void adminMenu() {
        while (true) {
            System.out.println("\n----- Admin Menu -----");
            System.out.println("1. View All Requests");
            System.out.println("2. Update Status");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> requestService.getAllRequests().forEach(System.out::println);
                case 2 -> updateStatus();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // -------------------- UPDATE REQUEST STATUS --------------------
    private static void updateStatus() {
        System.out.print("Enter Request ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("1. Pending\n2. In Progress\n3. Completed\n4. Rejected");
        System.out.print("Enter choice: ");
        int s = sc.nextInt();
        sc.nextLine();

        RequestStatus status = switch (s) {
            case 1 -> RequestStatus.PENDING;
            case 2 -> RequestStatus.IN_PROGRESS;
            case 3 -> RequestStatus.COMPLETED;
            default -> RequestStatus.REJECTED;
        };

        requestService.updateStatus(id, status);
        System.out.println("Status updated!");
    }
}
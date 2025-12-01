📘 Smart City Management System (Core Java Project)

A fully functional console-based Smart City Request Management System built using Core Java, following a clean, modular architecture with DAO, Service, Model, and Exception layers.
The system allows citizens to submit service requests and admins to manage them, with file-based persistent storage so data remains even after restarting the program.

🚀 Features
👤 Citizen Features

Register a new citizen account

Login securely

Submit service requests

View request history

Request types:

   Water Issue

   Electricity Issue

   Road Damage

   Other

All data is saved and loaded automatically

🛠️ Admin Features

Admin login

View all citizen requests

Update request status:

Pending

In Progress

Completed

Rejected

Persistent storage ensures nothing is lost

💾 Storage & Persistence

Users are stored in users.dat

Requests are stored in requests.dat

Auto-incrementing Request IDs

Data survives even after application restarts

Uses Java Object Serialization

🧱 Tech Stack

Java 17

OOP Principles

DAO Pattern

Service Layer Architecture

Exception Handling

File Serialization (Persistence)

Scanner-based CLI Interface

📁 Project Structure
SmartCityCoreJava/
│
├── src/
│   └── com/smartcity/
│       ├── app/
│       │   └── MainApp.java
│       ├── dao/
│       │   ├── RequestDAO.java
│       │   └── UserDAO.java
│       ├── exceptions/
│       │   └── AuthenticationException.java
│       ├── model/
│       │   ├── User.java
│       │   ├── Citizen.java
│       │   ├── Admin.java
│       │   ├── ServiceRequest.java
│       │   ├── RequestType.java
│       │   └── RequestStatus.java
│       └── service/
│           ├── AuthService.java
│           └── RequestService.java
│
├── users.dat
├── requests.dat
└── README.md

▶️ How to Run the Project
1️⃣ Navigate to the project folder
cd SmartCityCoreJava

2️⃣ Compile all Java files

(Windows PowerShell)

javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })


(Optional Mac/Linux)

find . -name "*.java" > sources.txt
javac -d out @sources.txt

3️⃣ Run the application
java -cp out com.smartcity.app.MainApp

📝 Sample Screenshots (Optional)

Create a folder named screenshots/ and include PNG images:

screenshots/
   login.png
   citizen-menu.png
   admin-menu.png
   requests.png


Then reference them like:

![Login](screenshots/login.png)

🌱 Future Enhancements

Convert backend to Spring Boot

Connect full web-based UI (HTML/CSS/JS)

Add MySQL database support

Advanced request filtering

Priority levels for requests

Notification system

Authentication hashing (BCrypt)

⭐ Author

Suhas Gorantala
Full Stack Java Developer Aspirant

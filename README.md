# Demo Web Products - Documentation

A simple Spring Boot 3 Web Application for managing products with basic CRUD and Security features.

## 🚀 Technologies Used
- **Java 21**
- **Spring Boot 3.5.11**
- **Spring Data JPA** (Persistence)
- **Spring Security** (Authentication & Authorization)
- **Thymeleaf** (Server-side UI)
- **Bootstrap 5 & Bootstrap Icons** (Styling)
- **MySQL / H2** (Database)
- **Lombok** (Boilerplate reduction)

## 🛠 Features
- **Product Management:** View, create, edit, and delete products.
- **Search:** Search products by name using keywords.
- **Security:**
  - **ADMIN:** Full access (Create, Edit, Delete).
  - **USER:** Read-only access (View products and Search).
- **Layouts:** Uses Thymeleaf Layout Dialect for consistent UI across pages.

## 📁 Project Structure
- `com.nabgha.demowebproducts.entities`: Database entities (Product).
- `com.nabgha.demowebproducts.repository`: Data access interfaces (Spring Data JPA).
- `com.nabgha.demowebproducts.security`: Security configuration.
- `com.nabgha.demowebproducts.web`: Web Controllers handling HTTP requests.
- `src/main/resources/templates`: HTML views using Thymeleaf.

## ⚙️ How to Run
1. Ensure you have **Java 21** installed.
2. Configure your database in `src/main/resources/application.properties`.
3. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the app at: `http://localhost:8080`

## 📝 UI Guide
- **Home/Products:** Main dashboard showing all products.
- **Search:** Located at the top right of the products table.
- **Edit/Delete:** Icons located in the "Action" column (ADMIN only).
- **New Product:** Button at the top left of the table (ADMIN only).

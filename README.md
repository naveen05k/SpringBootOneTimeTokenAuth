![image](https://github.com/user-attachments/assets/62118eda-f023-4f6e-b997-cd09f51b999f)

```markdown
# 🔒 One-Time Token Email Authentication using Spring Boot

A **Spring Boot** project that sends a **One-Time Token (OTT)** via email.  
After verifying the token, users can **access protected APIs** and get redirected to a **dashboard page**.

---

## 📚 Project Description

This project demonstrates a secure **One-Time Login Link** system, where:
- A random token is generated for a user.
- The token is emailed as a clickable link.
- The user clicks the link to validate the token.
- Upon successful validation, the user is redirected to a secured dashboard.
- Tokens expire after a set duration and can only be used once.

Perfect for use cases like:
- **Magic Link Authentication** (like Slack, Medium)
- **Passwordless login flows**
- **Email confirmation systems**

---

## 🚀 Features

- Generate secure random tokens.
- Send One-Time-Token via email (link format).
- Validate token and allow access to protected resources.
- Custom success and error pages using Thymeleaf.
- Token expiration and single-use protection.
- Full Spring Boot + Thymeleaf setup.
- Professional email templates (optional enhancement).
  
---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Thymeleaf (for HTML pages)
- MySQL or H2 Database
- Java Mail Sender

---

## 🏗️ How It Works

1. User requests token generation via `/api/token/generate?email=your@email.com`.
2. Backend generates a secure token and sends an email with a clickable login link.
3. User clicks the emailed link: `http://localhost:8080/api/token/secure?token=xyz123`.
4. Token is validated:
    - If valid → Redirect to dashboard 🎯
    - If invalid/expired → Show error page ❌

---

## 📥 API Endpoints

| Method | Endpoint | Description |
|:------:|:---------|:------------|
| `POST` | `/api/token/generate?email={email}` | Generate token and send email |
| `GET` | `/api/token/secure?token={token}` | Validate token and redirect |
| `GET` | `/api/token/dashboard` | User dashboard page |

---

## 📦 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/one-time-token-springboot.git
cd one-time-token-springboot
```

### 2. Configure Database

Edit `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ott_project
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Configure Email Sender

Use Gmail SMTP (example):

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

**(Tip: Use Gmail App Passwords if using 2FA.)**

### 4. Run the Application

```bash
mvn spring-boot:run
```

### 5. Access

- API: `http://localhost:8080/api/token/generate?email=your@email.com`
- Dashboard: `http://localhost:8080/api/token/dashboard`

---

## 📸 Screenshots


| Generate Link Email | Dashboard Page | Access Denied |
|:--------------------:|:--------------:|:-------------:|
| ![email screenshot](images/![image](![image](https://github.com/user-attachments/assets/2b19fd8f-ca11-49f8-9b99-c223464093d8)
| ![dashboard screenshot](![image](https://github.com/user-attachments/assets/a8484587-95cf-4eac-b85c-5e095d563cb2)
| ![error page](![image](https://github.com/user-attachments/assets/b5383bfd-ddf2-4e1f-8ca3-3baeb5aa35bb)

_(You can capture real screenshots after building it!)_

---

## 📈 Future Improvements

- Expiry timers for tokens.
- JWT Token version.
- Frontend integration with React.js or Vue.js.
- Admin panel to manage tokens.
- Logging and monitoring.

---

## 📢 Contributing

Pull requests are welcome!  
For major changes, please open an issue first to discuss what you would like to change.

---

## 📜 License

This project is licensed under the **MIT License**.  
Feel free to use, modify, and share it!

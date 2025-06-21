# 🚀 Jetpack Compose Login UI App

This is a simple Android app built using **Jetpack Compose**. It demonstrates a login screen with input validation and mock backend authentication using a local `users.json` file.

---

## 📱 Features

- ✅ Beautiful UI with Material3
- ✅ Email format validation
- ✅ Password length check (min 6 characters)
- ✅ Toggle password visibility
- ✅ Local user verification from `users.json`
- ✅ Toast messages for success/failure
- ✅ Forgot Password & Sign Up placeholders

---

## 📂 Folder Structure
app/
├── src/
│ └── main/
│ ├── assets/
│ │ └── users.json # Mock backend
│ ├── java/com/example/loginpageui/
│ │ ├── MainActivity.kt
│ │ └── LoginScreen.kt
│ └── res/
│ └── drawable/wheel.png # App logo


---

## ▶️ How to Run

1. Clone the repo:

   ```bash
   git clone https://github.com/Abhi95081/LoginPageUI.git
   
2. Open the project in Android Studio.

3. Place users.json in:
   
app/src/main/assets/users.json

4. Run the app on an emulator or physical device (API 24+).

## 📄 Sample users.json

[
  {
    "email": "abhi@gmail.com",
    "password": "123456"
  },
  {
    "email": "abhirou7@gmail.com",
    "password": "Abhi@123"
  }
]

## 🧰 Dependencies Used

// Jetpack Compose
    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")

// Gson for JSON parsing
implementation("com.google.code.gson:gson:2.10.1")

## 📸 Screenshots
![image](https://github.com/user-attachments/assets/e8b08334-a2e1-413e-8341-2794af5862cb)
![image](https://github.com/user-attachments/assets/a099d8e4-114d-4c9e-8992-b9c0c628f406)

## 🔐 Future Improvements
Add navigation to home screen

Add Sign-Up functionality

Use Room or Firebase for user data

Implement session management

## 📜 License
This project is open-source under the MIT License.

## 🙋‍♂️ Author
Abhishek Roushan
👨‍💻 GitHub: github.com/Abhi95081

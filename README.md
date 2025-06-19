# 📱 Android REST API Integration with Retrofit (GET & POST)

This Android project demonstrates how to integrate **GET** and **POST** requests using **Retrofit** in **Kotlin**, with UI handled using Fragments and Bottom Navigation.

## 🚀 Features

- ✅ GET API integration using Retrofit
- ✅ POST API integration using Retrofit
- 🔜 UPDATE API (Coming soon)
- 🔜 MVVM Architecture (Coming after Update)
- 🧭 Bottom Navigation with Fragment transitions
- 🔧 Written in **Kotlin**
- 🧩 Modular UI using **Fragments**

---

## 🧑‍💻 Tech Stack

| Layer              | Technology               |
|-------------------|--------------------------|
| Language           | Kotlin                   |
| Networking         | Retrofit + Gson          |
| Architecture       | Currently MVC, Moving to MVVM |
| UI                 | Fragments + BottomNavigationView |
| JSON Parsing       | GsonConverterFactory     |

---

## 📂 Project Structure

```plaintext
com.example.restapi_retrofit/
├── MainActivity.kt                 # Hosts Bottom Navigation & Fragments
├── DataModal.kt                    # Data class for request/response
├── RetrofitInstance.kt             # Singleton object for Retrofit setup
├── ApiInterface.kt                 # Defines API endpoints

└── fragments/
    ├── GetFragment.kt              # GET data and display
    ├── PostFragment.kt             # POST user input to API
    └── UpdateFragment.kt           # (Planned) UPDATE API integration
```

## 📡 APIs Used

- **GET:** `https://jsonplaceholder.typicode.com/posts/1`
- **POST:** `https://reqres.in/api/users`

---

## 📸 UI Overview

- **GetFragment**: Displays title and body from a GET API.
- **PostFragment**: Takes name & job from user, sends it via POST request.
- **UpdateFragment**: To be implemented.

---

## 🧪 How to Run

1. Clone the project:
   ```bash
   git clone https://github.com/your-username/retrofit-android-demo.git
2. Open in Android Studio Arctic Fox or newer.
3. Run on emulator or device with internet access.

## ✍️ Planned Features
🔁 UpdateFragment: Handle PUT/PATCH requests

🧠 MVVM Architecture migration

✅ Input validation improvements

💬 Snackbar/Toast refactor with lifecycle-safety

## 📖 Kotlin Concepts Used
lateinit for view initialization

object for Retrofit singleton

when expression for fragment switching

Fragment lifecycle (onCreateView)

Null-safe operators ?., !!

Retrofit enqueue() for async networking

## 📸 App Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/27a9df6d-d6b7-4810-a2a0-c2a46e506f7d" alt="Screenshot 1" width="22%" />
  <img src="https://github.com/user-attachments/assets/f23b2364-e2aa-4ca5-a081-adbf43149164" alt="Screenshot 2" width="22%" />
  <img src="https://github.com/user-attachments/assets/818f26c3-6d7a-4d93-b6c5-dadf8d287c6a" alt="Screenshot 4" width="22%" />
  <img src="https://github.com/user-attachments/assets/41c0b54b-ff13-4b0c-8a75-7d9f2a5431de" alt="Screenshot 3" width="22%" />
</p>




## 🤝 Contribution
Feel free to fork, raise issues, or create pull requests.

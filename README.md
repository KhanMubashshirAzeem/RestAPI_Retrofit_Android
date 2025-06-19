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

com.example.restapi_retrofit/
│
├── MainActivity.kt # Hosts Bottom Navigation & Fragments
├── DataModal.kt # Data class for request/response
├── RetrofitInstance.kt # Singleton object for Retrofit setup
├── ApiInterface.kt # Defines API endpoints
│
└── fragments/
├── GetFragment.kt # GET data and display
├── PostFragment.kt # POST user input to API
└── UpdateFragment.kt # (Planned) UPDATE API integration


---

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

✍️ Planned Features
🔁 UpdateFragment: Handle PUT/PATCH requests

🧠 MVVM Architecture migration

✅ Input validation improvements

💬 Snackbar/Toast refactor with lifecycle-safety

📖 Kotlin Concepts Used
lateinit for view initialization

object for Retrofit singleton

when expression for fragment switching

Fragment lifecycle (onCreateView)

Null-safe operators ?., !!

Retrofit enqueue() for async networking


🤝 Contribution
Feel free to fork, raise issues, or create pull requests.

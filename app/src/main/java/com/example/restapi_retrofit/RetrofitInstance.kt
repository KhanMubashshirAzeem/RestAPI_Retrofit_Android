package com.example.restapi_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// ✅ Kotlin Concept: object
// Singleton design pattern — only one instance of RetrofitInstance exists.
object RetrofitInstance {

    // ✅ Kotlin Concept: val
    // Immutable variable holding Retrofit builder

    // ✅ Kotlin Concept: by lazy
    // Lazy initialization — executes only when accessed first time
    private val retrofit by lazy {
        // ✅ Kotlin Concept: function chaining & builder pattern
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com") // Base API URL
            .addConverterFactory(GsonConverterFactory.create()) // Gson for JSON parsing
            .build() // Builds Retrofit instance
    }

    // ✅ Kotlin Concept: val with lazy
    // Retrofit interface created only when needed
    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}

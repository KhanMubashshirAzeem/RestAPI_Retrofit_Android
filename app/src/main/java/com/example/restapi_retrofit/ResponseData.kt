package com.example.restapi_retrofit

// ✅ Kotlin Concept: data class
// Used to hold structured data with automatic toString(), equals(), etc.
data class ResponseData(
    val body: String,    // ✅ val: Immutable variable (read-only)
    val id: Int,
    val title: String,
    val userId: Int
)

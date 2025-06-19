package com.example.restapi_retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// ✅ Kotlin Concept: interface
// Defines abstract methods to be implemented by Retrofit dynamically
interface ApiInterface {

    // ✅ Kotlin Concept: function (fun)
    // Abstract function to perform a GET request
    @GET("/posts/1") // ✅ Annotation — Retrofit uses this to map HTTP GET
    fun getData(): Call<ResponseData> // ✅ Generic Type: Call<T>

    // Post request
    @POST("users")
    fun creatsPost(@Body dataModal: DataModal): Call<DataModal>
}

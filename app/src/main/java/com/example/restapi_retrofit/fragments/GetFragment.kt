package com.example.restapi_retrofit.fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.restapi_retrofit.R
import com.example.restapi_retrofit.ResponseData
import com.example.restapi_retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetFragment : Fragment() {

    // Declare views as lateinit variables to initialize later
    private lateinit var titleTextView: TextView
    private lateinit var bodyTextView: TextView
    private lateinit var getDataButton: Button

    // onCreateView inflates the layout (fragment_get.xml)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment layout
        val view = inflater.inflate(R.layout.fragment_get, container, false)

        // Initialize views using view.findViewById
        titleTextView = view.findViewById(R.id.title)
        bodyTextView = view.findViewById(R.id.body)
        getDataButton = view.findViewById(R.id.getData)

        // Set a click listener on the button
        getDataButton.setOnClickListener {
            getData()
        }

        return view
    }

    // Function to fetch data from API using Retrofit
    private fun getData() {
        // ProgressDialog shows a loading spinner
        val progressDialog = ProgressDialog(requireContext()) // requireContext() gives context in Fragment
        progressDialog.setMessage("Please wait")
        progressDialog.show()

        // Make API call using Retrofit
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<ResponseData?> {
            // on successful API response
            override fun onResponse(call: Call<ResponseData?>, response: Response<ResponseData?>) {
                Log.d("RESPONSE_STATUS", "Code: ${response.code()}, Body: ${response.body()}")

                if (response.isSuccessful && response.body() != null) {
                    val responseData = response.body()
                    titleTextView.text = responseData?.title
                    bodyTextView.text = responseData?.body
                } else {
                    Toast.makeText(requireContext(), "No data received", Toast.LENGTH_SHORT).show()
                }

                progressDialog.dismiss()
            }

            // on API failure
            override fun onFailure(call: Call<ResponseData?>, t: Throwable) {
                // Show error message
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })
    }
}

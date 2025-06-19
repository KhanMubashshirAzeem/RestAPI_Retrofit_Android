package com.example.restapi_retrofit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.restapi_retrofit.DataModal
import com.example.restapi_retrofit.R
import com.example.restapi_retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// ✅ Kotlin Concept: Class declaration extending Fragment
class PostFragment : Fragment() {

    // ✅ Kotlin Concept: lateinit
    // Used for late initialization of view components
    private lateinit var nameEditText: EditText
    private lateinit var jobEditText: EditText
    private lateinit var postDataButton: Button
    private lateinit var responseTextView: TextView
    private lateinit var loadingBar: ProgressBar

    // ✅ Kotlin Concept: override function (Lifecycle method of Fragment)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment (fragment_post.xml)
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        // ✅ Initialize views using findViewById
        nameEditText = view.findViewById(R.id.userName)       // EditText for user name
        jobEditText = view.findViewById(R.id.userJob)         // EditText for user job
        postDataButton = view.findViewById(R.id.sendData)     // Button to post data
        responseTextView = view.findViewById(R.id.responseTextview) // TextView to show response
        loadingBar = view.findViewById(R.id.idLoadingPB)      // ProgressBar for loading state

        // ✅ Set OnClickListener on button (Lambda function used here)
        postDataButton.setOnClickListener {
            val name = nameEditText.text.toString()   // Get user input
            val job = jobEditText.text.toString()

            // ✅ Input validation using if-else
            if (name.isEmpty() || job.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter both values", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // ✅ Call the function to POST data to server
                postData(name, job)
            }
        }

        // ✅ Return the inflated view for display
        return view
    }

    // ✅ Function to send POST request using Retrofit
    private fun postData(name: String, job: String) {

        // ✅ Show loading progress bar
        loadingBar.visibility = View.VISIBLE

        // ✅ Create a DataModal object (request body)
        val dataModal = DataModal(name, job)

        // ✅ Make network request using Retrofit
        RetrofitInstance.apiInterface.creatsPost(dataModal).enqueue(object : Callback<DataModal> {

            // ✅ onResponse: Called when the server responds
            override fun onResponse(call: Call<DataModal>, response: Response<DataModal>) {
                // Hide the progress bar
                loadingBar.visibility = View.GONE

                if (response.isSuccessful) {
                    val responseData = response.body()

                    // ✅ Safe call operator (?.) to avoid null pointer exception
                    val result =
                        "Response Code: ${response.code()}\n" + "Name: ${responseData?.name}\n" + "Job: ${responseData?.job}"

                    // ✅ Display result in TextView
                    responseTextView.text = result

                    // ✅ Clear input fields
                    nameEditText.setText("")
                    jobEditText.setText("")

                    Toast.makeText(
                        requireContext(), "Data posted successfully!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // ✅ Error response (like 400, 500)
                    responseTextView.text = "Error: ${response.code()}"
                }
            }

            // ✅ onFailure: Called when there’s a network error or exception
            override fun onFailure(call: Call<DataModal>, t: Throwable) {
                loadingBar.visibility = View.GONE
                // ✅ Show error message in TextView
                responseTextView.text = "Failure: ${t.localizedMessage}"
            }
        })
    }
}
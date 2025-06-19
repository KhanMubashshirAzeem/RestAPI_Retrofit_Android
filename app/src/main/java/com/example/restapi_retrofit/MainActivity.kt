package com.example.restapi_retrofit

// Required Android and Material imports
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.restapi_retrofit.fragments.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

// MainActivity inherits (extends) from AppCompatActivity
class MainActivity : AppCompatActivity() {

    // onCreate() is the entry point of an Activity lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enables layout to draw behind system bars (status/navigation bars)
        enableEdgeToEdge()

        // Setting the layout for this activity
        setContentView(R.layout.activity_main)

        // Apply system bar padding dynamically using insets (for full-screen layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Finding the BottomNavigationView from the layout
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Load the default fragment (GetFragment) when the app starts
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, GetFragment())
            .commit()

        // Set a listener to switch fragments when bottom nav items are clicked
        bottomNav.setOnItemSelectedListener { item ->

            // Choose the correct fragment based on which nav item is clicked
            val fragment = when (item.itemId) {
                R.id.getData -> GetFragment()        // Load GetFragment
                R.id.postData -> PostFragment()      // Load PostFragment
                R.id.updateData -> UpdateFragment()  // Load UpdateFragment
                else -> null                         // If no match, do nothing
            }

            // If fragment is not null, replace the current fragment with animation
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        android.R.anim.fade_in,    // Fade in new fragment
                        android.R.anim.fade_out    // Fade out old fragment
                    )
                    .replace(R.id.flFragment, it)  // Replace current fragment
                    .commit()                      // Commit the transaction
                true
            } ?: false  // Return false if fragment is null
        }
    }
}

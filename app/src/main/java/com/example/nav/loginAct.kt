package com.example.nav

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class loginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Obtain references to the views using findViewById
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        passwordEditText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                // Perform the action you want when Enter is pressed
                loginButton.performClick() // Simulate a click on the button
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

// Set an OnClickListener for the login button
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if the username and password are correct
            if (username == "user" && password == "user") {
                // Display a success message
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                // Navigate to the menu page (replace `MenuActivity::class.java` with your actual menu activity class)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Display an error message if the login is unsuccessful
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

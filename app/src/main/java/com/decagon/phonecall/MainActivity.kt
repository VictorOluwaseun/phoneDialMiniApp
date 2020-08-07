package com.decagon.phonecall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

/*
* **A phone call mini app**
* Activity with a button and EditText
* The textView holds the phone number
* The button trigger a call action to the number
* ** **
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declare variables
        val phoneNumber = findViewById<EditText>(R.id.editTextPhone)
        val callBtn = findViewById<Button>(R.id.triggerCall)

            //Add listener to the button
            callBtn.setOnClickListener{
                var number = phoneNumber.text.toString()
                    // Trim and check if it's empty
                    if (number.trim().isEmpty())
                        return@setOnClickListener
                // Intent constructor. Using Implicit Intent
                var callIntent = Intent(Intent.ACTION_DIAL)
                // Parse the phone number
                callIntent.data = Uri.parse("tel:$number")
                // start activity
                startActivity(callIntent)
            }

    }
}
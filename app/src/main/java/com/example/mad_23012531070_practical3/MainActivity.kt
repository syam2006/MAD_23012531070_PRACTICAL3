package com.example.mad_23012531070_practical3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    private lateinit var edtUrl: EditText
    private lateinit var edtPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtUrl = findViewById(R.id.editTextText2)
        edtPhone = findViewById(R.id.editTextText3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            val urlText = edtUrl.text.toString().trim()
            if (urlText.isNotEmpty()) {
                val fullUrl = if (urlText.startsWith("http://") || urlText.startsWith("https://")) {
                    urlText
                } else {
                    "https://$urlText"
                }
                val browserIntent = Intent(Intent.ACTION_VIEW, fullUrl.toUri())
                try {
                    startActivity(browserIntent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(this, "No web browser found to open URL.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter a URL.", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val phone = edtPhone.text.toString().trim()
            if (phone.isNotEmpty()) {
                val callIntent = Intent(Intent.ACTION_DIAL)
                callIntent.data = "tel:$phone".toUri()
                try {
                    startActivity(callIntent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(this, "No app found to handle calls.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter a phone number.", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            val callLogIntent = Intent(Intent.ACTION_VIEW).apply {
                type = CallLog.Calls.CONTENT_TYPE
            }
            try {
                startActivity(callLogIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No app found to view call logs.", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_VIEW).apply {
                type = "image/*"
            }
            try {
                startActivity(galleryIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No gallery app found.", Toast.LENGTH_LONG).show()
            }
        }


        findViewById<Button>(R.id.button5).setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivity(cameraIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No camera app found.", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.button6).setOnClickListener {
            val alarmIntent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            try {
                startActivity(alarmIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No alarm app found.", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.button7).setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            try {
                startActivity(loginIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Could not open login screen.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
package com.example.emailsender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.emailsender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun parseInput() {

    }

    fun buildIntent() {
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"

        sendIntent.putExtra(Intent.EXTRA_EMAIL, "")
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "")
        sendIntent.putExtra(Intent.EXTRA_TEXT, "")

        this.startActivity(sendIntent)
    }
}
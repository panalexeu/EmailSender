package com.example.emailsender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.emailsender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val emailValue = binding.emailInput.text.toString()
            val subjectValue = binding.subjectInput.text.toString()
            val textValue = binding.textInput.text.toString()

            if (emailValue.isEmpty() || subjectValue.isEmpty() || textValue.isEmpty()) {
                Toast.makeText(this, "One of the input field is empty!", Toast.LENGTH_SHORT).show()
            } else {
                buildIntent(emailValue, subjectValue, textValue)
            }
        }
    }

    fun buildIntent(email: String, subject: String, text: String) {
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"

        sendIntent.putExtra(Intent.EXTRA_EMAIL, email)
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        sendIntent.putExtra(Intent.EXTRA_TEXT, text)

        this.startActivity(sendIntent)
    }
}
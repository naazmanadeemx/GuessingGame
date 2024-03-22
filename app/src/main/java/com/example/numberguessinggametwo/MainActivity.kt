package com.example.numberguessinggametwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        var guessCount = 0

        val maxGuesses = 5

        button.setOnClickListener {
            val input = editText.text.toString()

            if (input.isEmpty()) {
                resultTextView.text = "Please enter a number!"
                return@setOnClickListener
            }

            val number = input.toInt()
            guessCount++

            if (number > 100) {
                resultTextView.text = "Try again. The number is greater." //"The number is greater than 100"
            } else if (number == 100) {
                resultTextView.text =
                    "Congratulations! You guessed the correct number." //"The number is NOT greater than 100"
            }else {
                    resultTextView.text = "Try again. The number is smaller."
                }

            if (guessCount >= maxGuesses){
                resultTextView.text = "Sorry you've used up all $maxGuesses guesses"
                button.isEnabled = false
            }
        }



    }
}
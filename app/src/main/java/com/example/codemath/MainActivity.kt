package com.example.codemath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var weightInput: EditText
    private lateinit var feetInput: EditText
    private lateinit var inchesInput: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightInput = findViewById(R.id.weightInput)
        feetInput = findViewById(R.id.feetInput)
        inchesInput = findViewById(R.id.inchesInput)
        resultText = findViewById(R.id.resultText)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weight = weightInput.text.toString().toDoubleOrNull() ?: return
        val feet = feetInput.text.toString().toDoubleOrNull() ?: return
        val inches = inchesInput.text.toString().toDoubleOrNull() ?: return

        val heightInMeters = ((feet * 12) + inches) * 0.0254
        val bmi = weight / heightInMeters.pow(2)

        resultText.text = String.format("Your BMI is %.2f", bmi)
    }
}

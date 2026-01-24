package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            binding.totalResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_fifteen_percent -> 0.15
            else -> 0.10
        }

        var tip = tipPercentage * cost
        val total = cost + tip

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        val formattedTotal = NumberFormat.getCurrencyInstance().format(total)

        binding.tipResult.text = "Чаевые: $formattedTip"
        binding.totalResult.text = "Итого: $formattedTotal"
    }
}
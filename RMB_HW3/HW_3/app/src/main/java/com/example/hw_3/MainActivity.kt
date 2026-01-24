package com.example.hw_3

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_3.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    // 1. Инициализация View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSeekBar()
        setupButtons()
    }

    private fun setupSeekBar() {
        // 2. Настройка SeekBar для выбора скидки
        binding.discountSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.discountPercentageLabel.text = "Скидка: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun setupButtons() {
        // 3. Настройка кнопок "Рассчитать" и "Сброс"
        binding.calculateButton.setOnClickListener {
            calculate()
        }

        binding.resetButton.setOnClickListener {
            reset()
        }
    }

    private fun calculate() {
        val priceString = binding.priceInput.text.toString()

        // 4. Улучшенная валидация
        if (priceString.isEmpty()) {
            binding.priceInput.error = "Введите сумму счета"
            return
        } else {
            binding.priceInput.error = null
        }

        val price = priceString.toDouble()
        val discountPercent = binding.discountSeekbar.progress

        val savedAmount = price * (discountPercent / 100.0)
        val finalPrice = price - savedAmount

        val currencyFormat = NumberFormat.getCurrencyInstance()
        binding.savedAmountText.text = "Вы сэкономили: ${currencyFormat.format(savedAmount)}"
        binding.finalPriceText.text = "Итоговая цена: ${currencyFormat.format(finalPrice)}"
    }

    private fun reset() {
        // 5. Логика для кнопки "Сброс"
        binding.priceInput.text?.clear()
        binding.priceInput.error = null
        binding.discountSeekbar.progress = 15
        binding.savedAmountText.text = ""
        binding.finalPriceText.text = ""
    }
}
package com.gilorroristore.horoscapplication.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gilorroristore.horoscapplication.databinding.ActivityHoroscopeDetailBinding

class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {

    }
}
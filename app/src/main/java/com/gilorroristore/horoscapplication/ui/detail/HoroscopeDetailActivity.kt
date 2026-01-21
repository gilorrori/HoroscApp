package com.gilorroristore.horoscapplication.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.gilorroristore.horoscapplication.databinding.ActivityHoroscopeDetailBinding
import kotlin.getValue

class HoroscopeDetailActivity : AppCompatActivity() {
    private val horoscopeDetailViewModel by viewModels<HoroscopeDetailViewModel>()
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.type
        initUI()

    }

    private fun initUI() {

    }
}
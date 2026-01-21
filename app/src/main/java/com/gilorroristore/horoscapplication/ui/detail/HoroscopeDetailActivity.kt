package com.gilorroristore.horoscapplication.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.gilorroristore.horoscapplication.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private val horoscopeDetailViewModel by viewModels<HoroscopeDetailViewModel>()
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initListener()
        getPrediction()
        initUIState()
    }
    fun backPressed(){
        onBackPressedDispatcher.onBackPressed()
    }
    private fun initListener() {
        binding.ivBack.setOnClickListener {
            backPressed()
        }
    }

    private fun getPrediction() {
        horoscopeDetailViewModel.getHoroscope(args.type.name)
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> stateLoading()
                        is HoroscopeDetailState.Success -> stateSuccess(it)
                        is HoroscopeDetailState.Error -> stateError()
                    }
                }
            }
        }
    }

    private fun stateLoading() {
        binding.pb.isVisible = true
    }

    private fun stateSuccess(success: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = success.sign
        binding.tvBody.text= success.prediction
        Glide.with(this).load(success.icon).into(binding.ivDetail)
    }

    private fun stateError() {
        binding.pb.isVisible = false
    }
}
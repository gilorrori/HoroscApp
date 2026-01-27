package com.gilorroristore.horoscapplication.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.gilorroristore.horoscapplication.R
import com.gilorroristore.horoscapplication.databinding.ActivityHoroscopeDetailBinding
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Aquarius
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Aries
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Cancer
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Capricorn
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Gemini
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Leo
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Libra
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Pisces
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Sagittarius
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Scorpio
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Taurus
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        horoscopeDetailViewModel.getHoroscope(args.type)
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

    private fun stateSuccess(successHoroscope: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = successHoroscope.sign
        binding.tvBody.text = successHoroscope.prediction
        //Glide.with(this).load(success.icon).into(binding.ivDetail)
        val image = when (successHoroscope.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Gemini -> R.drawable.detail_gemini
            Taurus -> R.drawable.detail_taurus
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }

    private fun stateError() {
        binding.pb.isVisible = false
    }
}
package com.gilorroristore.horoscapplication.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gilorroristore.horoscapplication.databinding.FragmentHoroscopeBinding
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Aquarius
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Aries
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Cancer
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Capricorn
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Gemini
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Leo
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Libra
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Pisces
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Sagittarius
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Scorpio
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Taurus
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo.Virgo
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel
import com.gilorroristore.horoscapplication.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    /*Cuando se crea la vista*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHoroscopeBinding.inflate(inflater, container, false)
        return binding.root
    }

    /* Cuando se vista ha sido creada */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        horoscopeAdapter = HoroscopeAdapter() {
            initDetailHoroscope(it)
        }
        binding.rvHoroscope.adapter = horoscopeAdapter
        initUIState()
    }

    private fun initUIState() {
        // Este tipo de corrutina se engancha al ciclo de vida del fragment por eso se usa esta.
        lifecycleScope.launch {
            // Diferentes estados para el ciclo de vida del fragmento
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect { listCollected ->
                    horoscopeAdapter.updateList(listCollected)
                }
            }
        }
    }


    private fun initDetailHoroscope(horoscopeInfo: HoroscopeInfo) {
        /**
         * WARING: mandar objetos completos como param es mala práctica, antipattern
         */
        val type = when (horoscopeInfo) {
            Aquarius -> HoroscopeModel.Aquarius
            Aries -> HoroscopeModel.Aries
            Cancer -> HoroscopeModel.Cancer
            Capricorn -> HoroscopeModel.Capricorn
            Gemini -> HoroscopeModel.Gemini
            Leo -> HoroscopeModel.Leo
            Libra -> HoroscopeModel.Libra
            Pisces -> HoroscopeModel.Pisces
            Sagittarius -> HoroscopeModel.Sagittarius
            Scorpio -> HoroscopeModel.Scorpio
            Taurus -> HoroscopeModel.Taurus
            Virgo -> HoroscopeModel.Virgo
        }

        findNavController().navigate(HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type))
    }
}
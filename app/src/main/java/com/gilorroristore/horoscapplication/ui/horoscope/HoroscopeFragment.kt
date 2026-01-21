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
import com.gilorroristore.horoscapplication.databinding.FragmentHoroscopeBinding
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
        horoscopeAdapter = HoroscopeAdapter()

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
}
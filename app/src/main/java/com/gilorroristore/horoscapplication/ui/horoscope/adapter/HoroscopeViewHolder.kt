package com.gilorroristore.horoscapplication.ui.horoscope.adapter

import androidx.recyclerview.widget.RecyclerView
import com.gilorroristore.horoscapplication.databinding.ItemHoroscopeBinding
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo

class HoroscopeViewHolder(private val binding: ItemHoroscopeBinding): RecyclerView.ViewHolder(binding.root) {

    fun addItem(horoscopeInfo: HoroscopeInfo){
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = binding.root.context.getString(horoscopeInfo.name)
        binding.root.setOnClickListener {

        }
    }
}
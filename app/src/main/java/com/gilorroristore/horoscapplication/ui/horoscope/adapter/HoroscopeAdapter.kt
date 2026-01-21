package com.gilorroristore.horoscapplication.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gilorroristore.horoscapplication.databinding.ItemHoroscopeBinding
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var listHoroscopes: List<HoroscopeInfo> = emptyList()
) : RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(listHoroscopeInfo: List<HoroscopeInfo>){
        this.listHoroscopes = listHoroscopeInfo
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            ItemHoroscopeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
       holder.addItem(listHoroscopes[position])
    }

    override fun getItemCount() = listHoroscopes.size
}
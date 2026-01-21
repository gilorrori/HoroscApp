package com.gilorroristore.horoscapplication.ui.horoscope.adapter

import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.gilorroristore.horoscapplication.databinding.ItemHoroscopeBinding
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo

class HoroscopeViewHolder(
    private val binding: ItemHoroscopeBinding,
    private val onItemSelected: (HoroscopeInfo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {


    fun addItem(horoscopeInfo: HoroscopeInfo) {
        binding.clItemHoroscope.setOnClickListener {
            startAnimation(binding.ivHoroscope) {
                //Scope de newLambda que se ejecuta desde startRotation para ejecutar otra lambda
                onItemSelected(horoscopeInfo)
            }
        }
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = binding.root.context.getString(horoscopeInfo.name)
    }

    fun startAnimation(view: View, executeAnimation: () -> Unit) {
        view.animate().apply {
            duration = 200
            interpolator = DecelerateInterpolator()
            rotationBy(360f)
            withEndAction {
                executeAnimation()
            }
            start()
        }
    }
}
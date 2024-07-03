package com.base.base_source.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.base_source.databinding.ItemWeatherVerticalBinding

data class WeatherDataVertical(
    val iconRes: Int,
    val description: String,
    val tempLow: String,
    val tempHigh: String,
    val precipLow: Int,
    val precipHigh: Int
)

class WeatherAdapterVertical(private val weatherList: List<WeatherDataVertical>) :
    RecyclerView.Adapter<WeatherAdapterVertical.WeatherViewHolder>() {

    inner class WeatherViewHolder(private val binding: ItemWeatherVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherData: WeatherDataVertical) {
            binding.imageViewz.setImageResource(weatherData.iconRes)
            binding.textViewContent.text = weatherData.description
            binding.textView7.text = weatherData.tempLow
            binding.textView5.text = weatherData.tempHigh
            binding.circleCaretDown.setImageResource(weatherData.precipLow)
            binding.circleCaretUp.setImageResource(weatherData.precipHigh)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding =
            ItemWeatherVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}
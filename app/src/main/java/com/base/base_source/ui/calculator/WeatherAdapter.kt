package com.base.base_source.ui.calculator


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.base_source.databinding.ItemWeatherBinding

data class WeatherData(
    val time: String,
    val iconRes: Int,
    val temperature: String,
    val precipitation: String
)

class WeatherAdapter(private val weatherList: List<WeatherData>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherData: WeatherData) {
            binding.tvTime.text = weatherData.time
            binding.ivWeatherIcon.setImageResource(weatherData.iconRes)
            binding.tvTemperature.text = weatherData.temperature
            binding.tvPrecipitation.text = weatherData.precipitation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}

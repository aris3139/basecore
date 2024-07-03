package com.base.base_source.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.base_source.R
import com.base.base_source.databinding.FragmentCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        val weatherList = listOf(
            WeatherData("12:00 am", R.drawable.item_img_1, "47°", "5%"),
            WeatherData("1:00 pm", R.drawable.item_img_1, "59°", "0%"),
            WeatherData("2:00 pm", R.drawable.item_img_1, "47°", "5%")
        )
        val adapter = WeatherAdapter(weatherList)
        binding.rcv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rcv.adapter = adapter


        val weatherListVertical = listOf(
            WeatherDataVertical(
                R.drawable.cloudy,
                "Cloudy",
                "47º",
                "61º",
                R.drawable.circle_caret_down,
                R.drawable.circle_caret_up
            ),
            WeatherDataVertical(
                R.drawable.cloudy,
                "Partly sunny w/ showers",
                "41º",
                "57º",
                R.drawable.circle_caret_down,
                R.drawable.circle_caret_up
            ),
            WeatherDataVertical(
                R.drawable.cloudy,
                "Mostly sunny",
                "44º",
                "62º",
                R.drawable.circle_caret_down,
                R.drawable.circle_caret_up
            ),
            WeatherDataVertical(
                R.drawable.cloudy,
                "Partly sunny w/ showers",
                "43º",
                "63º",
                R.drawable.circle_caret_down,
                R.drawable.circle_caret_up
            ),
            WeatherDataVertical(
                R.drawable.cloudy,
                "Showers",
                "47º",
                "61º",
                R.drawable.circle_caret_down,
                R.drawable.circle_caret_up
            ),
            WeatherDataVertical(
                R.drawable.cloudy,
                "Cloudy",
                "47º",
                "61º",
                R.drawable.circle_caret_down,
                R.drawable.circle_caret_up
            )
        )

        val adapter1 = WeatherAdapterVertical(weatherListVertical)
        binding.rcvVertical.layoutManager = LinearLayoutManager(context)
        binding.rcvVertical.adapter = adapter1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {

    }


}
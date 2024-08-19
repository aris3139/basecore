package com.base.base_source.ui.chrome

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.base_source.R
import com.base.base_source.databinding.FragmentChromeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChromeFragment : Fragment() {

    private var _binding: FragmentChromeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChromeBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val trendList = listOf(
            SearchTrendData("đậu mùa"),
            SearchTrendData("siđa"),
            SearchTrendData("ngu đần"),
            SearchTrendData("súc vật"),
            SearchTrendData("12:00 am"),
            SearchTrendData("đậu mùa"),
            SearchTrendData("ngu đần"),
        )
        val adapter = ChromeAdapter(trendList)
        binding.rcv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = adapter


        // navigate

        binding.edtSearch2.setOnClickListener {
            findNavController().navigate(R.id.action_chromeFragment_to_searchFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.base.base_source.ui.chrome

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.base_source.data.entities.SearchItem
import com.base.base_source.databinding.FragmentChromeSearchBinding
import com.base.base_source.extentions.showKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() , ChromeAdapter.OnItemClickListener{

    private var _binding: FragmentChromeSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChromeSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val trendList = listOf(
            SearchItem("đậu mùa"),
            SearchItem("siđa"),
            SearchItem("ngu đần"),
            SearchItem("súc vật"),
            SearchItem("12:00 am"),
            SearchItem("đậu mùa"),
            SearchItem("ngu đần"),
        )

        binding.edtSearch2.requestFocus()
        context?.let { showKeyboard(it, binding.edtSearch2) }
        val adapter = ChromeAdapter(trendList , true,this)
        binding.rcv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = adapter

        // navigate
        binding.shapeableImageView2.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {

    }
}

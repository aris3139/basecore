package com.base.base_source.ui.syncdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.base_source.R
import com.base.base_source.data.entities.Entity
import com.base.base_source.databinding.FragmentMapBinding
import com.base.base_source.extentions.gone
import com.base.base_source.extentions.visible
import com.base.base_source.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SyncFragment : Fragment(), EntityAdapter.EItemListener {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SyncViewModel by viewModels()
    private lateinit var adapter: EntityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.entities.collectLatest { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            resource.data?.let { adapter.setItems(it) }
                            binding.progressBar.gone()
                        }
                        is Resource.Err -> {
                            Toast.makeText(requireContext(), resource.message, Toast.LENGTH_SHORT).show()
                            binding.progressBar.gone()
                        }
                        is Resource.Loading -> {
                            binding.progressBar.visible()
                        }
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = EntityAdapter(this)
        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.charactersRv.adapter = adapter
    }


    override fun onClickedItem(entity: Entity) {
        val bundle = bundleOf("data" to entity)
        findNavController().navigate(
            R.id.action_FirstFragment_to_SecondFragment, bundle
        )
    }
}
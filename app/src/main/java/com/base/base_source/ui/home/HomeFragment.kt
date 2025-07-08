package com.base.base_source.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.base.base_source.databinding.FragmentHomeBinding
import com.base.base_source.presentation.base.BaseFragment
import com.base.base_source.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>() {

    override val viewModel: HomeVM by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun setupUI() {
        // Setup your RecyclerView, click listeners, etc.
        binding.apply {
            // Example setup for a refresh layout if you have one
            // swipeRefreshLayout.setOnRefreshListener { viewModel.refreshData() }

            // Example setup for a RecyclerView if you have one
            // recyclerView.layoutManager = LinearLayoutManager(requireContext())
            // recyclerView.adapter = entityAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        // Observe the entity list from the original implementation
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.entities.collectLatest { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            // Update your adapter with the new data
                            // entityAdapter.submitList(resource.data)
                        }

                        is Resource.Err -> {
                        }

                        is Resource.Loading -> {
                            // Loading state is handled by BaseFragment
                        }
                    }
                }
            }
        }

        // Observe UI State
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest { state ->
                    state?.let { uiState ->
                        // Update UI based on state
                        // entityAdapter.submitList(uiState.entities)
                    }
                }
            }
        }

        // Observe UI Events
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collectLatest { event ->
                    when (event) {
                        is HomeUIEvent.NavigateToEntityDetail -> {
                            // Navigate to detail screen
                            // findNavController().navigate(HomeFragmentDirections.actionHomeToDetail(event.entityId))
                        }

                        is HomeUIEvent.ShowRefreshMessage -> {
                            Toast.makeText(requireContext(), "Data refreshed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }

    override fun handleLoading(isLoading: Boolean) {
        // Update loading UI elements
        // binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        // Or if you have a SwipeRefreshLayout:
        // binding.swipeRefreshLayout.isRefreshing = isLoading
    }
}
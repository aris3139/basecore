package com.base.base_source.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Base Fragment class that provides common functionality for all Fragments.
 * Handles ViewBinding and integration with BaseViewModel.
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel<*, *>> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected abstract val viewModel: VM

    /**
     * Create view binding
     */
    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = createBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Set up the user interface
     */
    protected open fun setupUI() {
        // Override in subclasses
    }

    /**
     * Observe the ViewModel's state and events
     */
    private fun observeViewModel() {
        // Observe loading state
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isLoading.collectLatest { isLoading ->
                    handleLoading(isLoading)
                }
            }
        }

        // Observe error messages
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.errorMessage.collectLatest { errorMessage ->
                    errorMessage?.let {
                        showError(it)
//                        viewModel.setErrorMessage(null)
                    }
                }
            }
        }

        // Additional observers should be implemented in subclasses
    }

    /**
     * Handle the loading state
     */
    protected open fun handleLoading(isLoading: Boolean) {
        // Override in subclasses to show/hide loading indicator
    }

    /**
     * Show an error message
     */
    protected open fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}

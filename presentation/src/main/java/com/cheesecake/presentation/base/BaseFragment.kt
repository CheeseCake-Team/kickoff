package com.cheesecake.presentation.base

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.cheesecake.presentation.BR
import com.cheesecake.presentation.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {
    protected abstract val layoutIdFragment: Int

    protected abstract val viewModel: ViewModel

    private lateinit var _binding: VDB

    protected val binding: VDB
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutIdFragment, container, false)

        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
            return root
        }
    }

    fun <T> collect(flow: Flow<T>, action: suspend (T) -> Unit) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collect(action)
            }
        }
    }

    protected fun changeStatusBarColor() {
        val statusBarColor = ContextCompat.getColor(requireContext(), R.color.cardSurface)
        requireActivity().window.statusBarColor = statusBarColor
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.S)
    protected fun resetStatusBarColor() {
        val defaultStatusBarColor: Int = android.R.color.system_accent1_0
        requireActivity().window.statusBarColor = defaultStatusBarColor
    }

    protected fun handleOnError(message: String,) {
        if (message.isNotEmpty()) {
            Snackbar.make(binding.root,message, Snackbar.LENGTH_SHORT).show()
        }
    }
}
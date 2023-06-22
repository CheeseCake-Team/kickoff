package com.cheesecake.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
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

    protected fun changeStatusBarColor(@ColorRes color: Int) {
        activity?.window?.let {
            it.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            it.statusBarColor = ContextCompat.getColor(requireContext(), color)
        }

    }

}
package com.cheesecake.presentation.screens.home

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

}
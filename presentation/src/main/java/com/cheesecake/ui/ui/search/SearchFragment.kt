package com.cheesecake.ui.ui.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutIdFragment = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecyclerView.adapter = SearchFragmentAdapter()

        viewModel.searchInput.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                Log.i("onViewCreated: ", it.toString())
                viewModel.onSearchInputChanged(it)
            }
        }
    }

}
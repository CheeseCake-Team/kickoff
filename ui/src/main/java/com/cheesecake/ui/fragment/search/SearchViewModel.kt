package com.cheesecake.ui.fragment.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetLeagueByNameUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getLeagueByNameUseCase: GetLeagueByNameUseCase,
    private val getTeamByNameUseCase: GetTeamByNameUseCase
) : BaseViewModel() {

    val searchText = MutableLiveData("")

    private val _searchResult = MutableLiveData<String>()

    fun getSearchResult() {
        viewModelScope.launch {
            searchText.value?.let { getLeagueByNameUseCase.invoke(it) }?.collect{

            }
        }
    }






}
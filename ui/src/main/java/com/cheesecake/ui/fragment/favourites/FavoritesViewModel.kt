package com.cheesecake.ui.fragment.favourites

import com.cheesecake.domain.usecases.GetAllFavoriteUseCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getAllFavoriteUseCase: GetAllFavoriteUseCase
): BaseViewModel() {

}
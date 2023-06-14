package com.cheesecake.presentation.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.ui.leagueMatches.LeagueMatchesHeadToHeadAdapter
import com.cheesecake.presentation.ui.search.SearchResult
import com.cheesecake.presentation.ui.search.SearchViewModel


@BindingAdapter("app:imageUrl")
fun ImageView.setImageFromUrl(imageUri: String?) {
    imageUri.let {
        Glide.with(this)
            .load(it)
            .centerCrop()
            .into(this)
    }
    //val imageUrl = imageUri.takeIf { !it.isNullOrEmpty() && !it.contains("image_not_available") } ?: R.drawable.no_image
}

@BindingAdapter("app:circularImageUrl")
fun ImageView.setCircularImageFromUrl(imageUri: String?) {
    imageUri.let {
        Glide.with(this)
            .load(it)
            .centerCrop()
            .transform(CircleCrop())
            .into(this)
    }
    //val imageUrl = imageUri.takeIf { !it.isNullOrEmpty() && !it.contains("image_not_available") } ?: R.drawable.no_image
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseAdapter<T>?)?.setItems(it)
    }
}

@BindingAdapter(value = ["app:searchItems"])
fun <T> setRecyclerItems(view: RecyclerView, items: SearchResult?) {
    items?.let {
        when(it) {
            is SearchResult.Team -> {
                (view.adapter as BaseAdapter<T>?)?.setItems(it.items as List<T>)
            }
            else -> {}
        }

    }
}

@BindingAdapter(value = ["app:fixtureItems"])
fun <T> setItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        val adapter = LeagueMatchesHeadToHeadAdapter()
        adapter.setItems(it as List<Fixture>)
        view.adapter = adapter
    }
}

@BindingAdapter(value = ["app:showLoading"])
fun showLoading(view: View, isVisible: Boolean?) {
    view.isVisible = !(isVisible == null || isVisible == false)

}

@BindingAdapter(value = ["app:viewVisibilityInLoading"])
fun hideWhenLoading(view: View, isVisible: Boolean) {
    view.isVisible = !isVisible
}

@BindingAdapter(value = ["app:showNoResultFound"])
fun <T> showWhenNoResult(view: FrameLayout, items: SearchResult?) {
    items?.let {
        when(it) {
            is SearchResult.Team -> { view.isVisible = it.items.isEmpty()}
            is SearchResult.League -> { view.isVisible = it.items.isEmpty() }
        }
    }
}

@BindingAdapter(value = ["app:onSearchInput"])
fun <T> onSearchBarInput(view: EditText, onSearch: (input: String) -> Unit) {
    view.doOnTextChanged { text, start, before, count ->
        onSearch(text.toString())
    }
}

@BindingAdapter("app:onSearchTextChanged")
fun EditText.onSearchTextChanged(viewModel: SearchViewModel) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            viewModel.onSearch(s.toString().trim())
        }

        override fun afterTextChanged(s: Editable?) {}
    })
}


@SuppressLint("SetTextI18n")
@BindingAdapter("app:matchScore")
fun TextView.setMatchScore(fixture: Fixture?) {
    fixture?.let {
        if (it.isFinished) this.text = "Finished\n  ${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
        else this.text = it.matchTime.toString()
    }
}
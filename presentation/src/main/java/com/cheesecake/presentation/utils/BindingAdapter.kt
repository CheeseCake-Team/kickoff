package com.cheesecake.presentation.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.screens.home.MatchItemUIState
import com.cheesecake.presentation.screens.homeSearch.HomeSearchAdapter
import com.cheesecake.presentation.screens.homeSearch.HomeSearchData
import com.cheesecake.presentation.screens.search.adapters.SearchAdapter
import com.cheesecake.presentation.screens.search.models.SearchResult
import com.cheesecake.presentation.screens.search.SearchViewModel


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


//@BindingAdapter(value = ["app:searchItems"])
//fun <T> setRecyclerItems(view: RecyclerView, items: SearchResult?) {
//    items?.let {
//        when(it) {
//            is SearchResult.Team -> {
//                (view.adapter as BaseAdapter<T>?)?.setItems(it.items as List<T>)
//            }
//            is SearchResult.League -> {
//                (view.adapter as BaseAdapter<T>?)?.setItems(it.items as List<T>)
//            }
//        }
//
//    }
//}

@BindingAdapter(value = ["app:listItems"])
fun <T> setListItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseListAdapter<T>?)?.submitList(items)
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseAdapter<T>?)?.setItems(it)
    }
}

@BindingAdapter(value = ["app:nestedSearchItems"])
fun <T> setNestedSearchRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseAdapter<T>?)?.setItems(it.take(6))
    }
}

@BindingAdapter(value = ["app:showLoading"])
fun showLoading(view: View, isVisible: Boolean?) {
    view.isVisible = !(isVisible == null || isVisible == false)
}

@BindingAdapter(value = ["app:viewVisibilityOnItems"])
fun <T> hideIfItemsEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}

@BindingAdapter(value = ["app:viewVisibilityInLoading"])
fun hideWhenLoading(view: View, isVisible: Boolean) {
    if (isVisible) view.visibility = View.INVISIBLE else view.visibility = View.VISIBLE
}

@BindingAdapter(value = ["app:showNoResultFound"])
fun <T> showWhenNoResult(view: FrameLayout, items: List<SearchResult>?) {
    items?.let {
        view.isVisible = it.isEmpty()
    }
}


@BindingAdapter("app:onSearchTextChanged")
fun EditText.onSearchTextChanged(viewModel: SearchViewModel) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            viewModel.onQueryChange(s.toString().trim())
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


@BindingAdapter("app:scoreOrTime")
fun TextView.setMatchScore(item: MatchItemUIState?) {
    item?.let {
        when (it.matchState) {
            "FT" -> "Finished\n  ${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            else -> this.text = it.matchTime
        }
    }
}
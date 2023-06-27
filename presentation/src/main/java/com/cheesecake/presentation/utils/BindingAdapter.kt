package com.cheesecake.presentation.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.screens.home.MatchItemUIState
import com.cheesecake.presentation.screens.search.SearchViewModel
import com.cheesecake.presentation.screens.search.models.SearchResult
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


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
    imageUri?.let {
        Glide.with(this)
            .load(it)
            .centerCrop()
            .transform(CircleCrop())
            .into(this)
    }
    //val imageUrl = imageUri.takeIf { !it.isNullOrEmpty() && !it.contains("image_not_available") } ?: R.drawable.no_image
}

@BindingAdapter("app:loadSVG")
fun ImageView.setSvgImageFromUrl(imageUri: String?) {
    imageUri?.let {
        GlideToVectorYou
            .init()
            .with(this.context)
            .load(it.toUri(), this)
    }
}

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

@BindingAdapter(value = ["app:showLoading"])
fun showLoading(view: View, isVisible: Boolean?) {
    view.isVisible = !(isVisible == null || isVisible == false)
}

@BindingAdapter(value = ["app:viewVisibilityOnItems"])
fun <T> hideIfItemsEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}

@BindingAdapter(value = ["app:viewVisibilityOnItemsList"])
fun <T> showIfItemsNotEmpty(view: View, items: List<T>) {
    view.isVisible = items.isEmpty()
}

@BindingAdapter(value = ["app:viewVisibility"])
fun hideWhenLoading(view: View, isVisible: Boolean) {
    if (isVisible)
        view.visibility = View.INVISIBLE
    else view.visibility = View.VISIBLE
}
@BindingAdapter(value = ["app:viewVisibilityNoResult"])
fun showNoResult(view: View, isVisible: Boolean) {
    view.isInvisible  = !isVisible
}

@BindingAdapter(value = ["app:doNotShow"])
fun doNotShow(view: View, doNotWantToShow: Boolean) {
    view.isInvisible  = doNotWantToShow
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

@BindingAdapter("app:setMatchState")
fun TextView.setMatchState(isFinished: Boolean) {
    if (isFinished)
        text = resources.getString(R.string.finished)
    else isVisible = false
}

@BindingAdapter(
    "app:isFinished", "app:time", "app:homeTeamGoals", "app:awayTeamGoals",
    requireAll = true
)
fun TextView.setTimeOrResult(
    isFinished: Boolean,
    time: String,
    homeTeamGoals: Int,
    awayTeamGoals: Int
) {
    text = if (isFinished)
        "$homeTeamGoals  -  $awayTeamGoals"
    else time
}

@BindingAdapter(value = ["app:listItems"])
fun <T> setItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseListAdapter<T>?)?.submitList(items)
    }
}

@BindingAdapter("app:scoreOrTime")
fun TextView.setMatchScore(item: MatchItemUIState?) {
    item?.let {
        this.text = when (it.matchState) {
            "FT" -> "Finished\n${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            "LIVE" -> "Live\n${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            "CANC" -> "Match cancelled"
            "2H" -> "Second half\n${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            "1H" -> "First half\n${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            "ET" -> "Extra time\n${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            else -> it.matchTime
        }
    }
}

package com.cheesecake.presentation.utils

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.ui.leagueMatches.LeagueMatchesHeadToHeadAdapter


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
    isVisible?.let {
        Log.i("showLoading: ", isVisible.toString())
        view.isVisible = isVisible
    }
}

@BindingAdapter(value = ["app:viewVisibilityInLoading"])
fun hideWhenLoading(view: View, isVisible: Boolean) {
    view.isVisible = !isVisible
}

@BindingAdapter(value = ["app:showNoResultFound"])
fun <T>showWhenNoResult(view: FrameLayout, items: List<T>?) {
    items.let {
        view.isVisible = it!!.isEmpty()
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("app:matchScore")
fun TextView.setMatchScore(fixture: Fixture?) {
    fixture?.let {
        if (it.isFinished) this.text = "Finished\n  ${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
        else this.text = it.matchTime.toString()
    }
}
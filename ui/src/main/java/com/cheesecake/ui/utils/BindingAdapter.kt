package com.cheesecake.ui.utils

import android.app.PendingIntent.OnFinished
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.ui.base.BaseAdapter


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

@BindingAdapter(value = ["app:showLoading"])
fun showLoading(view: ProgressBar, isShowing: Boolean?) {
    isShowing?.let {
        Log.i("showLoading: ", isShowing.toString())
        view.isVisible = isShowing
    }

    @BindingAdapter("app:matchScore")
    fun TextView.setMatchScore(fixtureEntity: FixtureEntity?) {
        fixtureEntity?.let {
            if (it.isFinished) this.text = "Finished\n  ${it.homeTeamGoals}  -  ${it.awayTeamGoals}"
            else this.text = it.matchTime.toString()
        }
    }
}
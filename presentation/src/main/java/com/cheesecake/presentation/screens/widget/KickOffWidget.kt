package com.cheesecake.presentation.screens.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.AppWidgetTarget
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.repository.IFootballRepository
import com.cheesecake.presentation.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class KickOffWidget  : AppWidgetProvider() {
    @Inject
    lateinit var repository:IFootballRepository

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, repository)
        }
    }

}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    repository: IFootballRepository

) {
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.kick_off_widget)

    // Instruct the widget manager to update the widget

    CoroutineScope(Dispatchers.IO).launch {
        val matches = repository.getMatchesByLeagueIdAndSeason("Africa/Cairo" , 42 , 2022)
        CoroutineScope(Dispatchers.Main).launch {
            setImprovisedAdapter(matches , views , context)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

fun setImprovisedAdapter(matches: List<Fixture>, views: RemoteViews, context: Context) {
    val listOfViews = listOf(R.id.home_team_names, R.id.away_team_names, R.id.home_team_image_logo , R.id.away_team_image_logo , R.id.times)

    matches.forEachIndexed { index, fixture ->
        views.setTextViewText(listOfViews[0], fixture.homeTeamName)
        views.setTextViewText(listOfViews[1], fixture.awayTeamName)

        val homeTarget = AppWidgetTarget(context, listOfViews[2], views, index)
        Glide.with(context)
            .asBitmap()
            .load(fixture.homeTeamLogoUrl) // Replace with the actual logo URL property from your Fixture model
            .into(homeTarget)

        val awayTarget = AppWidgetTarget(context, listOfViews[3], views, index)
        Glide.with(context)
            .asBitmap()
            .load(fixture.awayTeamLogoUrl) // Replace with the actual logo URL property from your Fixture model
            .into(awayTarget)

        views.setTextViewText(listOfViews[4] , fixture.matchTime)
    }
}





package com.cheesecake.presentation.widgets

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetWidgetMatchesUseCase
import com.cheesecake.presentation.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MatchWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return MatchItemFactory(applicationContext, null)
    }

    class MatchItemFactory @Inject constructor(
        private val context: Context,
        private val getWidgetMatchesUseCase: GetWidgetMatchesUseCase?
    ) : RemoteViewsFactory {

        private lateinit var list: List<Fixture>

        override fun onCreate() {
            GlobalScope.launch {
                list = getWidgetMatchesUseCase?.let { it("Afirca/Egypt", 39, 2022) }!!
            }
        }

        override fun onDataSetChanged() {

        }

        override fun onDestroy() {

        }

        override fun getCount() = list.size

        override fun getViewAt(position: Int): RemoteViews {
            val currentItem = list[position]
            val views = RemoteViews(context.packageName, R.layout.widget_item_match)
            views.setTextViewText(R.id.widget_home_team, currentItem.homeTeamName)
            views.setTextViewText(R.id.widget_away_team, currentItem.awayTeamName)
            views.setTextViewText(R.id.widget_match_time, currentItem.matchState)
            return views
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getViewTypeCount() = 1

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun hasStableIds() = true
    }
}
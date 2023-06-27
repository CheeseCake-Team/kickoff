package com.cheesecake.presentation.widgets

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import android.widget.Toast
import com.cheesecake.presentation.R

data class Item(val home:String,val time:String,val away:String,)

class MatchWidgetService: RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return MatchItemFactory(applicationContext)
    }

    class MatchItemFactory(private val context: Context): RemoteViewsFactory{

        private val list = listOf(Item("Hassan","05:15","Shehab"),
            Item("Ali","09:10","Mujtaba"),
            Item("Mahmoud","09:30","Abdo"),
            Item("Anwaar","09:10","Nahla"))

        override fun onCreate() {
            TODO()
        }

        override fun onDataSetChanged() {
            TODO()
        }

        override fun onDestroy() {
            TODO()
        }

        override fun getCount() = list.size

        override fun getViewAt(position: Int): RemoteViews {
            val currentItem = list[position]
            val views = RemoteViews(context.packageName, R.layout.widget_item_match)
            views.setTextViewText(R.id.widget_home_team,currentItem.home)
            views.setTextViewText(R.id.widget_away_team,currentItem.away)
            views.setTextViewText(R.id.widget_match_time,currentItem.time)
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
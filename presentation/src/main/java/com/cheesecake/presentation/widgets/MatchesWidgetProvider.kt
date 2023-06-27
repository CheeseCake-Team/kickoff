package com.cheesecake.presentation.widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.cheesecake.presentation.R
import com.cheesecake.presentation.screens.mainactivity.MainActivity

class MatchesWidgetProvider: AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        for (widgetId in appWidgetIds!!){
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                context,0,
                intent,
                PendingIntent.FLAG_MUTABLE or
                        PendingIntent.FLAG_UPDATE_CURRENT
            )

            val serviceIntent = Intent(context,MatchWidgetService::class.java)
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,widgetId)

            val views = RemoteViews(context!!.packageName, R.layout.widget_layout_viewer)

            views.setOnClickPendingIntent(R.id.widget_match_item_layout,pendingIntent)
            views.setRemoteAdapter(R.id.widget_list_holder,serviceIntent)
            views.setEmptyView(R.id.widget_list_holder,R.id.widget_empty_holder)
            appWidgetManager?.updateAppWidget(widgetId,views)
        }
    }
}
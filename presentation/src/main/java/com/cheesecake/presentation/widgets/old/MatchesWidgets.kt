package com.cheesecake.presentation.widgets.old

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.cheesecake.presentation.MainActivity
import com.cheesecake.presentation.R

class MatchesWidgets : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val intent = Intent(context,MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_MUTABLE
            )
            val views = RemoteViews(context.packageName,R.layout.one_widget_match)
            views.setOnClickPendingIntent(R.id.one_match_layout,pendingIntent)
            updateAppWidget(context, appWidgetManager, appWidgetId)
            appWidgetManager.updateAppWidget(appWidgetId,views)
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    val views = RemoteViews(context.packageName, R.layout.matches_widgets)
    views.setTextViewText(R.id.appwidget_text, widgetText)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
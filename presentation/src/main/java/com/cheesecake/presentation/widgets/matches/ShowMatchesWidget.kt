package com.cheesecake.presentation.widgets.matches

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.cheesecake.presentation.R

/**
 * Implementation of App Widget functionality.
 */
class ShowMatchesWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray
    ) {
       updateAll(context,javaClass)
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        val pendingIntent = initPendingIntent(context,javaClass)
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private fun initPendingIntent(context: Context?, cls: Class<*>): PendingIntent? {
        val intent = Intent(context, cls)
        return PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )
    }

    private fun updateAll(context: Context, cls: Class<*>){
        val manager = AppWidgetManager.getInstance(context)
        val ids = manager.getAppWidgetIds(ComponentName(context,cls))
        ids.forEach { id -> updateAppWidget(context,manager,id) }
    }


    private fun updateAppWidget(
        context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int
    ) {
        val widgetText = context.getString(R.string.appwidget_text)
        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.show_matches_widget)
        views.setTextViewText(R.id.appwidget_text, widgetText)

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}


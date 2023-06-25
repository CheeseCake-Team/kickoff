package com.cheesecake.presentation.widgets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.cheesecake.domain.KickoffException
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R

class WidgetAdapter(context: Context, private val matchList: List<Fixture>) :
    ArrayAdapter<Fixture>(context, 0, matchList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView

        if (itemView == null) {

            itemView =
                LayoutInflater.from(context)
                    .inflate(R.layout.one_widget_match, parent, false)

            val match = getItem(position)

            match?.let {
                itemView?.findViewById<TextView>(R.id.widget_home_team_name)?.text = it.homeTeamName
                itemView?.findViewById<TextView>(R.id.widget_away_team_name)?.text = it.awayTeamName
                itemView?.findViewById<TextView>(R.id.widget_match_time)?.text = it.matchState
            }

            return itemView

        }else {
            throw KickoffException.NullPointerOccur()
        }
    }

    override fun getCount() = matchList.size
}
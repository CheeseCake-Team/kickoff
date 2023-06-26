package com.cheesecake.presentation.widgets.matches

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R

class MatchesAdapter(
    private val context: Context,
    @LayoutRes private val layout: Int,
    var items: List<Fixture>
): ArrayAdapter<Fixture>(context,layout,items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder = LayoutInflater.from(context).inflate(layout,null)
        val home = holder.findViewById<TextView>(R.id.widget_home_team_name)
        val away = holder.findViewById<TextView>(R.id.widget_away_team_name)
        val date = holder.findViewById<TextView>(R.id.widget_match_time)
        var item = items[position]
        home.text = item.homeTeamName
        away.text = item.awayTeamName
        date.text = item.matchState
        return holder
    }

}
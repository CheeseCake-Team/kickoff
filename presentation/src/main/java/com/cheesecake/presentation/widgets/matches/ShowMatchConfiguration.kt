package com.cheesecake.presentation.widgets.matches

import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cheesecake.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowMatchConfiguration: AppCompatActivity() {

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        val viewModel : MatchWidgetViewModel by viewModels()
        val adapter = MatchesAdapter(this, R.layout.show_matches_widget,viewModel.state.value.data)
        findViewById<ListView>(R.id.matches_widget_list).adapter = adapter
    }
}
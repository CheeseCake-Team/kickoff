package com.cheesecake.kickoff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.CountriesResponse
import com.cheesecake.data.models.LeagueResponse
import com.cheesecake.data.models.TimezoneResponse
import com.cheesecake.data.remote.IFootballApiService
import com.cheesecake.data.utils.DataState
import com.cheesecake.data.utils.wrapWithFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService: IFootballApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
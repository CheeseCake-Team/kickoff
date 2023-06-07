package com.cheesecake.ui.fragment.league

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentsAdapter(
    fragmentActivity: FragmentActivity, private val fragmentList: List<Fragment>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]

}
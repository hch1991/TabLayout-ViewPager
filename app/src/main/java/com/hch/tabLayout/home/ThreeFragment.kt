package com.hch.tabLayout.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hch.tabLayout.R
import com.hch.tabLayout.base.BaseFragment

class ThreeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_three, container, false)
        initData()
        return view
    }

    private fun initData(){

    }
}
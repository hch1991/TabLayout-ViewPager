package com.hch.tabLayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.hch.tabLayout.R
import com.hch.tabLayout.home.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private val titles = arrayOf("TAB1", "TAB2", "TAB3", "TAB4", "TAB5")
    private val tabs = intArrayOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)
//    private val tabs = intArrayOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)
    private val tabsSelect = intArrayOf(R.mipmap.vr,R.mipmap.vr,R.mipmap.vr,R.mipmap.vr,R.mipmap.vr)
    private val fragments: ArrayList<Fragment> = ArrayList()
    private var pagerAdapter: FmPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    fun initData(){
        for (i in 0 until tabs.size) {
            getFragment(i)?.let { fragments.add(it) }
            home_bottom_tab_tl.addTab(home_bottom_tab_tl.newTab())
        }

        home_bottom_tab_tl.setupWithViewPager(home_viewPager_vp,false);
        pagerAdapter = FmPagerAdapter(fragments,getSupportFragmentManager())
        home_viewPager_vp.setAdapter(pagerAdapter);

        for (i in 0 until tabs.size) {
//            home_bottom_tab_tl.getTabAt(i)?.setText(titles[i])
            home_bottom_tab_tl.getTabAt(i)?.setIcon(tabs[i])
        }
        home_bottom_tab_tl.addOnTabSelectedListener(this)
        home_bottom_tab_tl.getTabAt(2)?.select()
    }

    fun getFragment(num:Int): Fragment? {
        when(num){
            0 ->return OneFragment()
            1 ->return TwoFragment()
            2 ->return ThreeFragment()
            3 ->return FourFragment()
            4 ->return FiveFragment()
        }
        return null
    }

    internal class FmPagerAdapter(private val fragmentList: List<Fragment>?, fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {

        override fun getCount(): Int {
            return if (fragmentList != null && !fragmentList.isEmpty()) fragmentList.size else 0
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList!![position]
        }

    }

    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
        p0?.position?.let { home_bottom_tab_tl.getTabAt(it)?.setIcon(tabs[it]) }
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        p0?.position?.let { home_bottom_tab_tl.getTabAt(it)?.setIcon(tabsSelect[it]) }
    }


}

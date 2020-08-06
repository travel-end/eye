package com.journey.eyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fragments:MutableMap<Int,Fragment>
    private val fragmentManager by lazy { supportFragmentManager }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragments = mutableMapOf(
            R.id.home to getFragment(HomeFragment::class.java),
            R.id.community to getFragment(CommunityFragment::class.java)
        )
        main_bottom_nav.run {
            setOnNavigationItemSelectedListener {menuItem->
                showFragment(menuItem.itemId)
                true
            }
            setOnNavigationItemReselectedListener {menuItem->
                val fragment = fragments.entries.find {
                    it.key == menuItem.itemId
                }?.value
            }
        }
        if (savedInstanceState == null) {
            val initialItemId = R.id.home
            main_bottom_nav.selectedItemId = initialItemId
            showFragment(initialItemId)
        }
    }

    private fun getFragment(clazz: Class<out Fragment>):Fragment {
        var fragment = fragmentManager.fragments.find{
            it.javaClass == clazz
        }
        if (fragment == null) {
            fragment = when(clazz) {
                HomeFragment::class.java->HomeFragment.newInstance()
                CommunityFragment::class.java -> CommunityFragment.newInstance()
                else -> throw IllegalAccessException("argument ${clazz.simpleName} is illegal")
            }
        }
        return fragment
    }
    private fun showFragment(menuItemId:Int) {
        val currentFragment = fragmentManager.fragments.find {
            it.isVisible && it in fragments.values
        }
        val targetFragment = fragments.entries.find {
            it.key == menuItemId
        }?.value
        fragmentManager.beginTransaction().apply {
            currentFragment?.let {
                if (it.isVisible) hide(it)
            }
            targetFragment?.let {
                if (it.isAdded) show(it) else add(R.id.main_fl, it)
            }
        }.commit()
    }
}
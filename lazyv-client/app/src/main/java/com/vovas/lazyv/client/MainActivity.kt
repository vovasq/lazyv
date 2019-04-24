package com.vovas.lazyv.client

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.vovas.lazyv.client.fragments.HomeFragment
import com.vovas.lazyv.client.fragments.MouseFragment
import com.vovas.lazyv.client.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                startFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_mouse -> {
                startFragment(MouseFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                startFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            navView.selectedItemId = R.id.navigation_home
        }

    }
}

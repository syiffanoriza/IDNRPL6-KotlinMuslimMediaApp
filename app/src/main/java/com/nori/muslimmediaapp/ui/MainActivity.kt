package com.nori.muslimmediaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.tabs.TabLayoutMediator
import com.nori.muslimmediaapp.R
import com.nori.muslimmediaapp.adapter.SectionPagerAdapter
import com.nori.muslimmediaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _bindng: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
    }

    private fun setUpViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tabList = arrayOf(
            "Common",
            "About Al Quran",
            "Al Jazeera",
            "Warn for Muslim"
        )
        TabLayoutMediator(binding.tabs, binding.vpNews) {
            tab, position -> tab.text = tabList[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu_main, menu)

    }
}
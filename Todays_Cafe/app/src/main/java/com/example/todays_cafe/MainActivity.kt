package com.example.todays_cafe

import android.app.TabActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TabHost
import com.example.todays_cafe.Fragments.*


class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("Log", "MainActivity - onCreate called")

        val tabHost = findViewById<TabHost>(android.R.id.tabhost)
        tabHost.setup(this.localActivityManager)

        if (tabHost != null) {
            addTab(tabHost, "승민1", "승민1", SeungMin1Fragment::class.java)
            addTab(tabHost, "승민2", "승민2", SeungMin2Fragment::class.java)
            addTab(tabHost, "상옥", "상옥", SangOkFragment::class.java)
            addTab(tabHost, "예진", "예진", YeJinFragment::class.java)
            addTab(tabHost, "Free", "Free", FreeFragment::class.java)

//            // 앱 실행 시 첫 화면 설정1
//            tabHost.currentTab = 2
        }
    }

    private fun addTab(tabHost: TabHost, name: String, indicator: String, className: Class<*>) {
        Log.v("Log", "MainActivity - addTab called")
        val tabSpec = tabHost.newTabSpec(name)
        tabSpec.setIndicator(indicator)
        val intent = Intent(this, className)
        tabSpec.setContent(intent)
        tabHost.addTab(tabSpec)
    }
}
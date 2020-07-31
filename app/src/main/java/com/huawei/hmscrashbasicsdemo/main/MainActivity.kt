package com.huawei.hmscrashbasicsdemo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.huawei.hmscrashbasicsdemo.R
import com.huawei.hmscrashbasicsdemo.crash.CrashService

class MainActivity : AppCompatActivity() {
    private lateinit var triggerCrashBtn: TextView
    private lateinit var stopCrashServiceBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        triggerCrashBtn = findViewById(R.id.button_trigger_crash);
        stopCrashServiceBtn = findViewById(R.id.button_stop_crashService);
        initView()
        startCrashService()
    }

    private fun startCrashService(){
        CrashService().enableAgCrashService();
    }

    private fun stopCrashService(){
        CrashService().disableAgCrashService();
    }
    private fun initView() {
        triggerCrashBtn.setOnClickListener {
            CrashService().testIt()
        }
        stopCrashServiceBtn.setOnClickListener {
            stopCrashService();
        }
    }
}
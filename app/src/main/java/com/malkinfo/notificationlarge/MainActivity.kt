package com.malkinfo.notificationlarge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**ok now run it*/
    }

    override fun onStop() {
        super.onStop()
        NotificationHelper(this).createNotification()
    }
}
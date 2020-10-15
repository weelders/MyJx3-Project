package com.heure2pointe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun onClickBtnSplash(view: View) {
        startActivity(Intent(this, IdRegionActivity::class.java))
        finish()
    }


}
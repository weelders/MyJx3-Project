package com.heure2pointe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //                                                           Temporaire !!!
    fun onClickNextButton(view: View) {
        startActivity(Intent(this, WebViewActivity::class.java))
    }
    //                                                           Temporaire !!!


}
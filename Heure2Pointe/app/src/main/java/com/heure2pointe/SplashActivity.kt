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

    //Onclick -> enregistre les données et passe à la page suivante
    fun onClick(view: View) {

        registData()
        startActivity(Intent(this, LoginActivity::class.java))

        finish()
    }
}
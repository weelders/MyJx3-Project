package com.heure2pointe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)


    }


    ///////////////////////////////////////////////////////////////////////////
    // ONCLICK
    ///////////////////////////////////////////////////////////////////////////
    fun onClickBtnFinish(view: View) {

        //To close app
        this.finishAffinity();
    }
    fun onClickBtnHistorique(view: View) {}
}
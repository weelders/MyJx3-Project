package com.heure2pointe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class IdAdelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_adel)

        //TODO
        val sp = getSharedPreferences("dataLogs", 0)

        val edt = sp.edit()

        edt.putString("usernameRegion","")
        edt.putString("passwordRegion","")

        edt.commit()
    }
    //TODO
    fun onClickBtnIdAdel(view: View) {}
}

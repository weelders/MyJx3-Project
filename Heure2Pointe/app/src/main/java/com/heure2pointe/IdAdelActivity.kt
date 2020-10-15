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

<<<<<<< HEAD
        edt.commit()
    }
    //TODO
    fun onClickBtnIdAdel(view: View) {}
}
=======


>>>>>>> 7568b1083cb4486aa6a31bf44cf898a77bc43e17

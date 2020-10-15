package com.heure2pointe

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_id_adel.*

<<<<<<< HEAD


=======
>>>>>>> 2b3290cab27ed65ba49b19c242e56f5dce152775








class IdAdelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_adel)

    }

    //Onclick -> enregistre les données et passe à la page suivante
    fun onClickBtnIdAdel(view: View) {

        registData()
        startActivity(Intent(this, LoginActivity::class.java))

        <<<<<<< HEAD
        finish()
    }

    fun registData() {
        //Stockage Preferences
        val gsp = getSharedPreferences("dataLogs", 0)
        val edt = gsp.edit()

        //Récup des données
        val nameAdel = et_name_adel.text.toString()
        val pswAdel = et_pwd_adel.text.toString()

        //Enregistre les données
        edt.putString("usernameAdel", nameAdel)
        edt.putString("passwordAdel", pswAdel)
        edt.putBoolean("isAlredyLog", true)

        //Apply
        edt.apply()
    }
}
=======



>>>>>>> 2b3290cab27ed65ba49b19c242e56f5dce152775

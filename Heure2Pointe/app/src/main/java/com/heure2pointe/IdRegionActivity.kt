package com.heure2pointe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_id_adel.*
import kotlinx.android.synthetic.main.activity_id_region.*

class IdRegionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_region)
    }

    fun onClickBtnIdRegion(view: View) {
        registData()
        startActivity(Intent(this, IdAdelActivity::class.java))
    }

    fun registData() {
        //Stockage Preferences
        val gsp = getSharedPreferences("dataLogs", 0)
        val edt = gsp.edit()

        //Récup des données
        val nameRegion = et_name_region.text.toString()
        val pswRegion = et_pwd_region.text.toString()

        //Enregistre les données
        edt.putString("usernameRegion", nameRegion)
        edt.putString("passwordRegion", pswRegion)

        //Apply
        edt.apply()
    }
}
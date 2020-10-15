package com.heure2pointe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

const val MENU_PREFERENCES = 50

const val urlAdel = "https://adel.adrar-formation.eu/login/index.php"
const val urlRegion = "https://www.formation-occ.com/index.php"

const val idUsernameAdel = "username"
const val idPasswordAdel = "password"
const val idButtonAdel = "loginbtn"

const val idUsernameRegion = "inputUsername"
const val idPasswordRegion = "inputPassword"
const val idButtonRegion = "btn"


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Si c'est la première connexion de la part de l'utilisateur
        if (!isAlreadyLog()) {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //DATA
        val gsp = getSharedPreferences("dataLogs", 0)
        val usernameAdel = gsp.getString("usernameAdel", "NA")!!
        val passwordAdel = gsp.getString("passwordAdel", "NA")!!

        val usernameRegion = gsp.getString("usernameRegion", "NA")!!
        val passwordRegion = gsp.getString("passwordRegion", "NA")!!


        //Connexion Region
        logScriptWV(wv_Region, urlRegion, idUsernameRegion, idPasswordRegion, idButtonRegion, usernameRegion, passwordRegion)

        //Connexion Adel
        logScriptWV(wv_Adel, urlAdel, idUsernameAdel, idPasswordAdel, idButtonAdel, usernameAdel, passwordAdel)

    }

///////////////////////////////////////////////////////////////////////////
// MENU
///////////////////////////////////////////////////////////////////////////

    //Remplir le menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menu!!.add(0, MENU_PREFERENCES, 0, "Préférences").setIcon(R.drawable.ic_baseline_settings_24)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //Load activity
            MENU_PREFERENCES -> {
                startActivity(Intent(this, IdRegionActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    ///////////////////////////////////////////////////////////////////////////
// WebView Script
///////////////////////////////////////////////////////////////////////////
//WebView Configure and start connexion
    fun logScriptWV(wv: WebView, url: String, idUsername: String, idPassword: String, idButton: String, username: String, password: String) {
        wv.webViewClient = WebViewClient()
        wv.settings.javaScriptEnabled = true
        wv.loadUrl(url)
        wv.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                autoFillAndClick(wv, idUsername, idPassword, idButton, username, password)
                //TODO gérer les status & erreurs
            }
        })
    }

    //Connexion automatique
    fun autoFillAndClick(wv: WebView, idUsername: String, idPassword: String, idButton: String, username: String, password: String) {
        //Auto-fill Text
        wv.loadUrl("javascript:(function() { document.getElementById('$idUsername').value = '$username'; ;})()")
        wv.loadUrl("javascript:(function() { document.getElementById('$idPassword').value = '$password'; ;})()")
        //Auto click Button
        wv.loadUrl("javascript:(function() { document.getElementById('$idButton').click(); })()") //For Adel
        //TODO faire le click sur l'élément button de la région

        wv.loadUrl("javascript:(function() { document.getElementsByClassName('btn')[0].click(); })()") //For Region
    }


    ///////////////////////////////////////////////////////////////////////////
// FUN Utils
///////////////////////////////////////////////////////////////////////////
//Vérifie si c'est la premiere connexion de l'utilisateur
    fun isAlreadyLog(): Boolean {
        val gsp = getSharedPreferences("dataLogs", 0)
        val isAlreadyLog = gsp.getBoolean("isAlreadyLog", false)

        return isAlreadyLog
    }


    fun onFinishScript() {

    }
}
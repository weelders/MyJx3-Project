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

val usernameAdel = "your_username"
val passwordAdel = "your_password"

val usernameRegion = "your_username"
val passwordRegion = "your_password"


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


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


    //WebView Configure and start connexion
    fun logScriptWV(wv: WebView, idUsername: String, idPassword: String, idButton: String, username: String, password: String) {
        wv_Adel.webViewClient = WebViewClient()
        wv_Adel.settings.javaScriptEnabled = true
        wv_Adel.loadUrl(urlAdel)
        wv_Adel.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                autoFillAndClick(idUsername, idPassword, idButton, username, password)
                //TODO gérer les status & erreurs
                Toast.makeText(view.context, "Log ?", Toast.LENGTH_SHORT).show()
            }
        })
    }

    //Connexion automatique
    fun autoFillAndClick(idUsername: String, idPassword: String, idButton: String, username: String, password: String) {
        //Auto-fill Text
        wv_Adel.loadUrl("javascript:(function() { document.getElementById('$idUsername').value = '$username'; ;})()")
        wv_Adel.loadUrl("javascript:(function() { document.getElementById('$idPassword').value = '$password'; ;})()")
        //Auto click Button
        wv_Adel.loadUrl("javascript:(function() { document.getElementById('$idButton').click(); })()")
    }
}
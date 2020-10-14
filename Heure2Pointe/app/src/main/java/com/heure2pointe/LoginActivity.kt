package com.heure2pointe

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

val urlAdel = "https://adel.adrar-formation.eu/login/index.php"

val username = "your_username"
val password = "your_password"

val idUsername = "username"
val idPassword = "password"
val idButton = "loginbtn"

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        webview.webViewClient = WebViewClient()
        webview.settings.javaScriptEnabled = true

        webview.loadUrl(urlAdel)
        webview.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                autoFillAndClick(idUsername, idPassword, idButton, username, password)
                //TODO Valider message
            }
        })
    }

    fun autoFillAndClick(idUsername: String, idPassword: String, idButton: String, username: String, password: String) {

        //Auto-fill Text
        webview.loadUrl("javascript:(function() { document.getElementById('$idUsername').value = '$username'; ;})()")
        webview.loadUrl("javascript:(function() { document.getElementById('$idPassword').value = '$password'; ;})()")

        //Auto click Button
        webview.loadUrl("javascript:(function() { document.getElementById('$idButton').click(); })()")

        
    }
}
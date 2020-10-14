package com.heure2pointe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlin.concurrent.thread

class WebViewActivity : AppCompatActivity() {

    var myThread: Thread? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)


        webview.webViewClient = WebViewClient()
        webview.settings.javaScriptEnabled = true

    }

    ///////////////////////////////////////////////////////////////////////////
    // ONCLICK
    ///////////////////////////////////////////////////////////////////////////

    //onClick
    fun onClickSearchWeb(view: View) {

        val url = et_url.text.toString()

        if (myThread == null || myThread?.state == Thread.State.TERMINATED) {
            myThread = thread {
                runOnUiThread {
                    webview.loadUrl(url)
                }
            }
        } else {
            Toast.makeText(this, "Chargement déjà en cours", Toast.LENGTH_SHORT).show()
        }


    }
}
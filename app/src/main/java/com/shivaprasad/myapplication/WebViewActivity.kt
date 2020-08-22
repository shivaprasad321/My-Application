package com.shivaprasad.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {

    lateinit var webview : WebView
lateinit var weburl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        if(intent.hasExtra("url")){
            weburl = intent.getStringExtra("url");

        }

        webview = findViewById(R.id.webview);
        webview.loadUrl(weburl)



    }
}

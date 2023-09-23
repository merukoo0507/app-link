package com.example.app_link

import android.content.Intent
import android.content.Intent.URI_INTENT_SCHEME
import android.net.Uri
import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uriString = "https://www.example.com"
        val uri = Uri.parse(uriString)
        // 將 URI 轉換為字符串
        val uriAsString = uri.toString()
        Log.d("MainActivity", "uriAsString = $uriAsString")

        // 再次將字符串轉換為 URI
        val parsedUri = Uri.parse(uriAsString)
        Log.d("MainActivity", "parsedUri = $parsedUri")

        // 檢查兩個 URI 是否相等
        val areUrisEqual = uri == parsedUri

        // 使用 Intent 傳遞 URI
        val intent = Intent(Intent.ACTION_VIEW, uri)
        val intentToUri = intent.toUri(URI_INTENT_SCHEME)
        Log.d("MainActivity", "intentToUri = $intentToUri")
//        startActivity(intent)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "https://www.google.com.tw/?hl=zh_TW"
        Linkify.addLinks(textView, Linkify.WEB_URLS)
    }
}
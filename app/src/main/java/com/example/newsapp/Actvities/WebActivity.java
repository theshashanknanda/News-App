package com.example.newsapp.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.newsapp.R;

public class WebActivity extends AppCompatActivity {
    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webView);

        getSupportActionBar().setTitle("Source");

        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(webView.canGoBack()){
            webView.goBack();
        }
    }
}

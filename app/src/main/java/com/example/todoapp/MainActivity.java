package com.example.todoapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Build;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

//AppCompat
public class MainActivity extends AppCompatActivity {
    public WebView webView;
    public Context context;
    private MyWebViewClient myWebViewClient;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebViewClient myWebViewClient = new MyWebViewClient();

        context = this;
        webView = findViewById(R.id.main_web_view);
        webView.setWebViewClient(myWebViewClient);


        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setCacheMode(WebSettings.LOAD_NO_CACHE);
        ws.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        String url = "http://172.30.1.71:5001/";
        webView.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient
    {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
        {
            System.out.println("shouldOverrideUrlLoading...");
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}
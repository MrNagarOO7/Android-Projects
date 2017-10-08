package com.example.mrnagar.browser;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyBrowser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);
        Uri url=getIntent().getData();
        WebView w1=(WebView)findViewById(R.id.w1);
        w1.setWebViewClient(new Callback());
        w1.loadUrl(url.toString());
    }
    protected class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }
    }
}

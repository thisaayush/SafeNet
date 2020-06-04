package com.aayushdevelopsapp.safenet;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")
    protected void BrowserDisplay(){
        EditText Enterurl = (EditText) findViewById(R.id.enterUrl);
        String url = Enterurl.getText().toString();
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        boolean isFound1 = url.contains("https://");
        boolean isFound2 = url.contains("http://");
        if(!isFound1 && !isFound2) {
            browser.loadUrl("https://www.google.com/search?q=" + url);
            Log.d("test", "query");
        }else{
            browser.loadUrl(url);
            Log.d("test", "url");
        }
        browser.animate().alpha(100).setDuration(5000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Browse = (Button) findViewById(R.id.browse);
        Browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowserDisplay();
            }
        });
        EditText Enterurl = (EditText) findViewById(R.id.enterUrl);
        Enterurl.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    BrowserDisplay();;
                    return true;
                }
                return false;
            }
        });
    }
}
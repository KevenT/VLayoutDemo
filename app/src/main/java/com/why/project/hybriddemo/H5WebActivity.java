package com.why.project.hybriddemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.Toast;

import com.why.project.vlayoutdemo.R;

public class H5WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5web);

        final H5WebView webView = (H5WebView) findViewById(R.id.webview);

        Intent it = getIntent();
        String url = it.getStringExtra("url");
        if (url==null){
            url  ="http://www.baidu.com/";
        }

//        webView.loadUrl("file:///android_asset/test.html");
        webView.loadUrl(url);
        webView.addJavascriptInterface(new JsInteration(), "android");


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:javacalljs()");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:javacalljswith(" + "'http://blog.csdn.net/Leejizhou'" + ")");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                webView.evaluateJavascript("sum(1,2)", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Toast.makeText(H5WebActivity.this,value,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }


    public  class  JsInteration{

        @JavascriptInterface
        public void javaFunction() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(H5WebActivity.this, "show", Toast.LENGTH_SHORT).show();
                }
            });
        }


        @JavascriptInterface
        public void javaFunction(final String text) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(H5WebActivity.this, text, Toast.LENGTH_SHORT).show();
//                    finish();
                }
            });
        }

    }




}

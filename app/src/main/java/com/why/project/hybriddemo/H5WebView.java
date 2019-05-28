package com.why.project.hybriddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * author: ZK.
 * date:   On 2017/6/20.
 */
public class H5WebView extends WebView {
    public H5WebView(Context context) {
        super(context);
        init();
    }


    public H5WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public H5WebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        WebSettings settings = getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);//支持javascript
        settings.setLoadWithOverviewMode(true);//缩放至屏幕的大小
        settings.setSupportZoom(true);//支持缩放
        settings.setLoadsImagesAutomatically(true);//支持自动加载图片
        settings.setAllowFileAccess(true);//设置可以访问文件
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设置通过js打开新窗口
        requestFocus(View.FOCUS_DOWN);

        setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                loadUrl(url);
                return false;
            }
        });

    }


}

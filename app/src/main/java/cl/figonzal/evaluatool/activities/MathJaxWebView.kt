/*
 
 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package
 
 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com
 
 Copyright (c) 2021
 
 Last modified 21-07-21 22:49
 */
package cl.figonzal.evaluatool.activities

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.webkit.WebSettings
import android.webkit.WebView

class MathJaxWebView @SuppressLint("SetJavaScriptEnabled") constructor(
    context: Context,
    attrs: AttributeSet?
) : WebView(context, attrs) {
    fun setText(text: String) {
        loadDataWithBaseURL(
            "http://bar",
            "<script type=\"text/x-mathjax-config\">" +
                    "  MathJax.Hub.Config({" +
                    "extensions: [\"tex2jax.js\"],messageStyle:\"none\"," +
                    "jax: [\"input/TeX\",\"output/HTML-CSS\"]," +
                    "tex2jax: {inlineMath: [['$','$'],['\\\\(','\\\\)']]}" +
                    "});" +
                    "</script>" +
                    "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=TeX-AMS-MML_HTMLorMML\"></script>" +
                    "" +
                    "</head>" +
                    "" +
                    "<body>" +
                    text +
                    "</body>" +
                    "</html>", "text/html", "utf-8", ""
        )
    }

    init {
        clearCache(true)
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        settings.javaScriptEnabled = true
        setBackgroundColor(Color.TRANSPARENT)
        settings.builtInZoomControls = false
        isHorizontalScrollBarEnabled = false
    }
}
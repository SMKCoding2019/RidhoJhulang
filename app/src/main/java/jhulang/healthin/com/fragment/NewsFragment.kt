package jhulang.healthin.com.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

import jhulang.healthin.com.R

class NewsFragment : Fragment() {

    private var mWebView: WebView? = null
    private var mProgressBar: ProgressBar? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_news, container, false)

        val mWebView = view.findViewById(R.id.myWebView) as WebView
        val mProgressBar= view.findViewById(R.id.progressBar) as ProgressBar

        mProgressBar.setMax(100)
        mWebView.loadUrl("https://health.detik.com/")

        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)
        mWebView.setWebViewClient(WebViewClient())

        return view
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (Uri.parse(url).host == "www.health.detik.com/") {

                return false
            } else {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }

        }
    }

}// Required empty public constructor

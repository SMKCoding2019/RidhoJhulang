package jhulang.healthin.com.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

import jhulang.healthin.com.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    var mWebView: WebView? = null
    val webSettings : WebSettings? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_news, container, false)

        mWebView = view.findViewById(R.id.myWebView)
        val webSettings = mWebView!!.settings


        mWebView!!.webViewClient = MyWebViewClient()
        mWebView!!.webChromeClient = WebChromeClient()
        mWebView!!.loadUrl("https://health.detik.com/")

        mWebView!!.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.VISIBLE
                super.onPageFinished(view, url)
            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
                super.onPageCommitVisible(view, url)
            }

        }

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

}



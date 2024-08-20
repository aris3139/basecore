package com.base.base_source.ui.chrome

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.base.base_source.R
import com.base.base_source.databinding.FragmentWebBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebFragment: Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    interface WebFragmentListener {
        fun onUrlChanged(url: String)
    }

    var listener: WebFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupWebView()
        setupSwipeRefresh()
        loadUrl("https://google.com.vn")
    }

    private fun setupWebView() {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.progressBar.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    val a = "K"
                    binding.progressBar.visibility = View.GONE
                    binding.swipeRefresh.isRefreshing = false
                    url?.let { listener?.onUrlChanged(it) }
                    view?.loadUrl(
                        """javascript:(function f() {
                        var btns = document.querySelector('[aria-label="Đăng nhập"]');
                        var parent = btns.parentElement;
                        btns.remove();
                        parent.style.width = '40px';
                        parent.style.height = '40px';
                        parent.innerHTML = `<span style="width: 32px;height: font-weight: 500; color: #fff; 32px;font-size: 18px;background-color: blue;border-radius: 50%;display: inline-block;text-align: center;line-height: 32px;">$a</span>`;
                      })()"""
                    )
                    view?.loadUrl(
                        """javascript:(function f() {
                        var aHref = document.querySelectorAll('a[href]');
                        aHref.forEach(item => {item.addEventListener('click', e => {e.preventDefault();e.stopPropagation();e.stopImmediatePropagation()})})
                      })()"""
                    )
                    view?.loadUrl(
                        """javascript:(function f() {
                        var btnBevgab = document.querySelector('#navd');
                        btnBevgab.addEventListener('click', e => {e.preventDefault();e.stopPropagation();e.stopImmediatePropagation()});
                      })()"""
                    )
                }

            }

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    binding.progressBar.progress = newProgress
                }
            }
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            binding.webView.reload()
        }
    }

    fun loadUrl(url: String) {
        binding.webView.loadUrl(url)
    }

    fun canGoBack(): Boolean = binding.webView.canGoBack()

    fun goBack() {
        binding.webView.goBack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.temperture.ui.gallery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.temperture.R


class GalleryFragment : Fragment() {

    //private lateinit var galleryViewModel: GalleryViewModel

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
////        galleryViewModel =
////            ViewModelProvider(this).get(GalleryViewModel::class.java)
////        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
////        val textView: TextView = root.findViewById(R.id.text_gallery)
////        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
////        return root
////    }
//
//    }

override fun onCreateView(inflater: LayoutInflater,
                          container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.activity_main, container, false).apply {

    // Variable and constants declaration
    val btnShow = findViewById<Button>(R.id.btnShow)
    val editText = findViewById<EditText>(R.id.editText)
    val btnExit = findViewById<Button>(R.id.btnExit)
    val webview = findViewById<WebView>(R.id.webview)
    btnExit.setOnClickListener { activity?.finish() }

    // Function that runs when the showButton is clicked.
    // It takes one argument, which is the text entered by the user.
    // Then it loads a web page, using the text as a part of the url.
    btnShow.setOnClickListener {

        // Declare the text from editText
        val text = editText.text

        // Show the text from the user in a small toast window
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

        // Make the webView
        webview.webViewClient = WebViewClient()
        webview.setBackgroundColor(Color.parseColor("#ffffff"))

        // Declare and assign the url to get, and adding the text the user entered
        var urltoget = "http://my.domain.org/apk_handler_app.php?action="+text

        // Load the url
        webview.loadUrl(urltoget)

        // To hide the softkeyboard when editText misses focus.
        editText.onEditorAction(EditorInfo.IME_ACTION_DONE)
    }
}
}
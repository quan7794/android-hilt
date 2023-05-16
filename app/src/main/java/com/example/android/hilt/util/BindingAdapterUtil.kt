package com.example.android.hilt.util

import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.hilt.R


class BindingAdapterUtil() {
    companion object {

    }
}

@BindingAdapter("textLimit")
fun TextView.textLimit(limitLength: Int) {
    background = resources.getDrawable(R.drawable.ic_launcher_background)
    d("textLimit", text.length.toString())
    val welcomeText = resources.getText(R.string.buttons_welcome)
    d("textLimit", welcomeText.toString())
    text = if (welcomeText.length > limitLength) welcomeText.substring(0, limitLength) else welcomeText
}
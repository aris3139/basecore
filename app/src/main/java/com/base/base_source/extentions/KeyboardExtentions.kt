package com.base.base_source.extentions

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


fun showKeyboard(context: Context, editText: EditText) {
    editText.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
}

fun hideKeyboard(context: Context, editText: EditText) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(editText.windowToken, 0)
}
package com.example.testcombine

import android.content.Context
import android.icu.text.NumberFormat
import android.widget.Toast


fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun toIdr(value: Int): String {
    return NumberFormat.getIntegerInstance().format(value).replace(",", ".")
}
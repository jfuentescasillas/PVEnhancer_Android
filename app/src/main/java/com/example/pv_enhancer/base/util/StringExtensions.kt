package com.example.pv_enhancer.base.util

import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*


// Decodes a string into MD5
fun String.toMD5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(this.toByteArray())).toString(16).padStart(32, '0')


// Converts a determined date format into a date specified by us
fun String.toMyDateFormat(): String {
    return try {
        val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        val outputFormatter = SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.getDefault())

        val date = inputFormatter.parse(this)
        val newString = outputFormatter.format(date?: "")

        newString
    } catch (e: Exception) {
        "N/A"
    }
}
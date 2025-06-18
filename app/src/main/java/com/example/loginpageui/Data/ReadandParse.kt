package com.example.loginpageui.Data

import android.content.Context
import com.google.gson.Gson

// Function to read JSON file from assets
fun readJsonFromAssets(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}


// Check if the email/password match a user in the JSON file
fun isValidUser(context: Context, inputEmail: String, inputPassword: String): Boolean {
    val json = readJsonFromAssets(context, "users.json")
    val users = Gson().fromJson(json, Array<User>::class.java).toList()
    return users.any { it.email == inputEmail && it.password == inputPassword }
}

package com.example.loginpageui

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpageui.Data.isValidUser


@Composable
fun LoginScreen() {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf<String?>(null) }

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun handleLogin() {
        when {
            !isValidEmail(email) -> {
                emailError = "Invalid email format"
            }

            password.length < 6 -> {
                Toast.makeText(context, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            }

            !isValidUser(context, email, password) -> {
                Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }

            else -> {
                emailError = null
                Toast.makeText(context, "Login successful for $email", Toast.LENGTH_LONG).show()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.wheel),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )

            // Title
            Text(
                text = "Log In Now",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )

            // Subtitle
            Text(
                text = "Please login to continue using our app",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )

            // Email Field
            OutlinedTextField(value = email, onValueChange = {
                    email = it
                    emailError = null
                },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                singleLine = true,
                isError = emailError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            // Email error text
            if (emailError != null) {
                Text(
                    text = emailError ?: "",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                singleLine = true,
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.ArrowForward else Icons.Default.ArrowBack,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            // Login Button
            Button(
                onClick = { handleLogin() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Login")
            }

            // Forgot Password
            Text(
                text = "Forgot Password?",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable {   Toast.makeText(context, "Forgot Password", Toast.LENGTH_SHORT).show() }
                    .padding(top = 4.dp)
            )

            // Sign Up
            Text(
                text = "Don't have an account? Sign Up",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable {    Toast.makeText(context, "Sign Up", Toast.LENGTH_SHORT).show() }
                    .padding(top = 4.dp)
            )
        }
    }
}

package com.example.zad1_2_grebenukov.presentation

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import com.example.zad1_2_grebenukov.R
import com.example.zad1_2_grebenukov.databinding.ActivitySignInBinding

class SignInActivity : Activity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSingIn.setOnClickListener {
                val loginToString = login.text.toString()
                val passwordToString = password.text.toString()
                val sharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                val savedLogin = sharedPreferences.getString("login", "")
                val savedPassword = sharedPreferences.getString("password", "")

                if (loginToString.isEmpty() || passwordToString.isEmpty()) {
                    Toast.makeText(this@SignInActivity, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
                } else {
                    if (savedLogin.isNullOrEmpty() && savedPassword.isNullOrEmpty()) {
                        editor.putString("login", loginToString)
                        editor.putString("password", passwordToString)
                        editor.apply()

                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {

                        if (loginToString == savedLogin && passwordToString == savedPassword) {
                            val intent = Intent(this@SignInActivity, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignInActivity, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }
}
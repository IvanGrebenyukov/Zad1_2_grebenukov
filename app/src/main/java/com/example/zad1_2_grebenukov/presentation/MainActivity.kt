package com.example.zad1_2_grebenukov.presentation

import android.app.Activity
import android.content.Intent

import android.os.Bundle
import com.example.zad1_2_grebenukov.R
import com.example.zad1_2_grebenukov.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnToChatOne.setOnClickListener{
            val intent = Intent(this, ChatListActivity::class.java)
            startActivity(intent)
        }
        binding.btnToChatTwo.setOnClickListener {
            val intent = Intent(this, ChatListActivity::class.java)
            startActivity(intent)
        }
        binding.btnToMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
    }
}
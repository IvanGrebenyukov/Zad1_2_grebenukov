package com.example.zad1_2_grebenukov.presentation

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.zad1_2_grebenukov.R
import com.example.zad1_2_grebenukov.databinding.ActivityMovieBinding

import com.squareup.picasso.Picasso
class MovieActivity : Activity() {
    private lateinit var binding: ActivityMovieBinding
    lateinit var poster1: ImageView
    lateinit var poster2: ImageView
    lateinit var poster3: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        poster1 = binding.rectangle1
        poster2 = binding.rectangle2
        poster3 = binding.rectangle3
        val movieTitles = listOf("Witcher", "Jessica Jones", "Magicians")
        val key = "6a3586ec"
        for (title in movieTitles) {
            val url = "https://www.omdbapi.com/?apikey=$key&t=$title"
            val queue = Volley.newRequestQueue(this)
            val request = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    val posterUrl = response.getString("Poster")
                    when (title) {
                        "Witcher" -> Picasso.get().load(posterUrl).into(poster1)
                        "Jessica Jones" -> Picasso.get().load(posterUrl).into(poster2)
                        "Magicians" -> Picasso.get().load(posterUrl).into(poster3)
                    }
                },
                {
                    Log.e("MyLog", "Volley error: $it")
                }
            )
            queue.add(request)

        }
    }
}
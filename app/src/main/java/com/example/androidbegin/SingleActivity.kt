package com.example.androidbegin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        //Get data from Shared Preference
        val prefs: SharedPreferences = getSharedPreferences("cache", Context.MODE_PRIVATE)
        val name = prefs.getString("room_name", "")
        val desc = prefs.getString("item_desc", "")
        val imageId = prefs.getInt("item_image", 0)

        //find 2 views and bind data
        val nameTextView : TextView = findViewById(R.id.roomName)
        val descTextView : TextView = findViewById(R.id.roomDesc)
        val imageView : ImageView = findViewById(R.id.roomImage)

        //Bind data to the view
        nameTextView.text = name
        descTextView.text = desc
        imageView.setImageResource(imageId)
    }
}
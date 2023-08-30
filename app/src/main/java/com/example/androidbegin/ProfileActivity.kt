package com.example.androidbegin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val profileAdapter: ProfileAdapter = ProfileAdapter(getProfiles())
        recyclerView.adapter = profileAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun getProfiles(): List<Profile>{
        return listOf(
            Profile(R.drawable.profile1, "Whitney Dough", "Senior Manager"),
            Profile(R.drawable.profile2, "Bradley Smith", "Junior Director"),
            Profile(R.drawable.profile3, "Samantha Dolaris", "HR"),
            Profile(R.drawable.profile4, "Whitney Dough", "Employee"),
            Profile(R.drawable.profile5, "Tom Cruise", "CEO"),
        )
    }
}
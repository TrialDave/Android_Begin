package com.example.androidbegin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //HOME
        val cardHome: CardView = findViewById(R.id.cardHome)
        cardHome.setOnClickListener {
            val intentHome = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intentHome)
        }

        //CHAT
        val cardChat: CardView = findViewById(R.id.cardChat)
        cardChat.setOnClickListener {
            val intentChat = Intent(applicationContext, ChatActivity::class.java)
            startActivity(intentChat)
        }

        //PROFILE
        val cardProfile: CardView = findViewById(R.id.cardProfile)
        cardProfile.setOnClickListener {
            val intentProfile = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(intentProfile)
        }

        //WIDGET
        val cardWidget: CardView = findViewById(R.id.cardWidget)
        cardWidget.setOnClickListener {
            val intentWidget = Intent(applicationContext, WidgetActivity::class.java)
            startActivity(intentWidget)
        }

        //SETTINGS
        val cardSettings: CardView = findViewById(R.id.cardSettings)
        cardSettings.setOnClickListener {
            val intentSettings = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(intentSettings)
        }



    }
}

// AndroidManifest.xml:File used to provide description abt the application

//Java Folder
//1. Used to create activities; all Kotlin codes are created





//Res Folder
//1.Drawable:Contains all the images and icons
//2.Layout:Contains xml fil
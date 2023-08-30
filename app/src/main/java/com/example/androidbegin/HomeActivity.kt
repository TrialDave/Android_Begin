package com.example.androidbegin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //binding data from the model, through ViewModel to the View
        recyclerView= findViewById(R.id.recyclerView)
        itemAdapter= ItemAdapter(applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        //===call the api and pass data to the recyclerView adapter===
        val helper = ApiHelper(applicationContext)
        val api = "http://erickapi.pythonanywhere.com/get_rooms"
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: JSONArray?) {
                val gson = GsonBuilder().create()
                val list = gson.fromJson(result.toString(), Array<Item>::class.java).toList()
                itemAdapter.setRoomItems(list)
            }

            override fun onSuccess(result: JSONObject?) {
                TODO("Not yet implemented")
            }

            override fun onFailure(result: String?) {
                TODO("Not yet implemented")
            }
        })

        recyclerView.adapter = itemAdapter
    }


    // Get data from API,,thus i commented the code
    //create generateData()
//    private fun generateData(): List<Item>{
//        return listOf(
//            Item(R.drawable.conference1, "Private Board Room", "Well spacious fitted with 2 screens to aid presentation"),
//            Item(R.drawable.conference2, "Spacious Rooms", "Affordable"),
//            Item(R.drawable.conference3, "Las Vegas Board Room", "Talk of comfort without disturbance,this is the place"),
//            Item(R.drawable.conference4, "Executive Deluxe", "Walls fitted with noise cancellation to ensure confidentiality"),
//            Item(R.drawable.conference5, "VIP Board Room", "Large enough to accommodate all the officials"),
//            Item(R.drawable.conference6, "Aesthetic Room", "Well lit with lights on the walls"),
//        )
//    }
}
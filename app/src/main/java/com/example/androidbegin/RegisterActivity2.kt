package com.example.androidbegin

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject
import java.util.Calendar

class RegisterActivity2 : AppCompatActivity() {
    private lateinit var btnDOB : Button
    private lateinit var editDOB : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)
        btnDOB=findViewById(R.id.btnDOB)
        editDOB=findViewById(R.id.editDOB)
        btnDOB.setOnClickListener {
            showDatePickerDilog()
        }

        val tvRegister1 : TextView = findViewById(R.id.tvRegister1)
        tvRegister1.setOnClickListener {
            val intentRegister = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intentRegister)
        }

        val buttonRegister : Button = findViewById(R.id.registerButton)
        buttonRegister.setOnClickListener {
            //get data from the preference
            val prefs: SharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE)
            val username = prefs.getString("username","")
            val phone = prefs.getString("phone","")
            val email = prefs.getString("email","")
            val password = prefs.getString("password","")
            val dob = editDOB.text.toString()

            // ASYNC LoopJ Library: Send ddata over the internet to the hosted API
            val helper =ApiHelper(applicationContext)

            //get API,body,
            val api = "http://erickapi.pythonanywhere.com/register"
            val body =JSONObject()
            body.put("username", username)
            body.put("phone", phone)
            body.put("email", email)
            body.put("password", password)
            body.put("dob", dob)

            helper.post(api,body,object : ApiHelper.CallBack{
                override fun onSuccess(result: JSONArray?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(result: JSONObject?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(result: String?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }
            })





            val intentRegister = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intentRegister)
        }


    }
private fun showDatePickerDilog(){
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        this, DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedYear-${selectedMonth+1}-$selectedDay"
            editDOB.setText(selectedDate)
        },
        year,month,day
    )
    datePickerDialog.show()
}
}
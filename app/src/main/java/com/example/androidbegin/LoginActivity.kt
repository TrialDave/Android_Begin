package com.example.androidbegin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // codes are executed here
        // functions are called here
        // objects are created here

        //find views based on ID

        val username: EditText = findViewById(R.id.usernamelg)
        val password: EditText = findViewById(R.id.passwordlg)
        //Add Event Listener
        val buttonLogin: Button = findViewById(R.id.loginButton)
        buttonLogin.setOnClickListener {
            // Intent -> message in android


            //Implement post request
            val api ="http://erickapi.pythonanywhere.com/login"
            val body = JSONObject()
            body.put("username", username.text.toString())
            body.put("password", password.text.toString())

            val helper = ApiHelper(applicationContext)
            helper.post(api, body,object : ApiHelper.CallBack{
                override fun onSuccess(result: JSONArray?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(result: JSONObject?) {
                    if (result!!.has("granted")){
                        val intentLogin = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intentLogin)
                    }
                    else{
                        Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()

                    }
                }

                override fun onFailure(result: String?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }
            })


        }
        val tvLogin: TextView = findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {
            val intentLogin = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intentLogin)
        }
    }

    // create functions and classes

}
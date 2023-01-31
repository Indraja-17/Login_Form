package com.capgemini.loginform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var password:EditText
    lateinit var button1:Button
    lateinit var button2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.name_et)
        password=findViewById(R.id.pwd_et)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button1.setOnClickListener{
            if(name.text.isEmpty()||password.text.isEmpty()) {
                Toast.makeText(this, "plese Ente details", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                button1.setOnClickListener {
                    val intent = Intent(this, Activity2::class.java)
                    startActivity(intent)
                }
            }
            }
        button2.setOnClickListener{
            val  intent=Intent(this,RegistrationPage::class.java)
            startActivity(intent)
        }

    }}
package com.capgemini.loginform

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.Month
import java.time.Year

 class RegistrationPage : AppCompatActivity(),DatePickerDialog.OnDateSetListener,
    View.OnClickListener {
    private lateinit var username: EditText
    private lateinit var phonenumber: EditText
    private lateinit var email: EditText
    private lateinit var qualifiaction: EditText
    private lateinit var address: EditText
    private lateinit var dateEdit: EditText
    private lateinit var datePicker: Button
    private lateinit var button3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)
        username = findViewById(R.id.name_r)
        phonenumber = findViewById(R.id.phone_r)
        email = findViewById(R.id.email_r)
        qualifiaction = findViewById(R.id.qualification_r)
        address = findViewById(R.id.address_r)
        button3 = findViewById(R.id.submit_btn)
        dateEdit = findViewById(R.id.dob_r)
        dateEdit.setOnClickListener(this)

        button3.setOnClickListener {
            if (username.text.isEmpty() || phonenumber.text.isEmpty() || email.text.isEmpty() || qualifiaction.text.isEmpty() || address.text.isEmpty()
            ) {
                Toast.makeText(this, "please Enter Details", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                button3.setOnClickListener {
                    val intent = Intent(this,Activity3::class.java)
                    startActivity(intent)
                }
            }
        }
    }

     @RequiresApi(Build.VERSION_CODES.N)
     override fun onClick(p0: View?) {
         val calendar=Calendar.getInstance()
         val year:Int=calendar.get(Calendar.YEAR)
         val month:Int=calendar.get(Calendar.MONTH)
         val day:Int=calendar.get(Calendar.DAY_OF_MONTH)
         val datePickerDialog=DatePickerDialog(this,this,year,month,day)
         datePickerDialog.show()
     }
     override fun onDateSet(view:DatePicker,year:Int,month:Int,dayOfMonth:Int){
         var value=("${month+1}/$dayOfMonth/$year").toString()
         dateEdit.setText(value)
     }

    }
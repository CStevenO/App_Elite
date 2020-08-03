package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ingresarboton: Button = findViewById(R.id.button)
        ingresarboton.setOnClickListener{
            val passwo: EditText = findViewById(R.id.editTextTextPassword)
            val usereli: EditText = findViewById(R.id.editTextTextPersonName)
            //val acc = "Select * from [ELITE].[dbo].[Covid.Empleados] where IDempleado $usereli"
            val myData = GetData()
            val Resulta = myData.data
            val toast = Toast.makeText(this, myData.ConnectionResult,Toast.LENGTH_SHORT)
            toast.show()
            if(("pastmtto") == usereli.text.toString() && ("@Elite202008.") == passwo.text.toString()){
                ingresarboton.text = "Exitoso"
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
            }
            else{
                ingresarboton.text = "Fallido"
            }
        }
    }
}


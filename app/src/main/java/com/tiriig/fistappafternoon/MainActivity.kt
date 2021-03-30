package com.tiriig.fistappafternoon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


class MainActivity : AppCompatActivity() {

    private lateinit var name : EditText
    private lateinit var phone : EditText
    private lateinit var email : EditText

    private lateinit var saveButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        saveButton = findViewById(R.id.save)

        saveButton.setOnClickListener {
            saveUser()
        }
    }

  private fun saveUser(){

      Thread{
          val db = ProjectDatabase.invoke(this)

          db.userDao().insert(User(0,
                  name.text.toString(),
                  phone.text.toString(),
                  email.text.toString()))
      }.start()

    }
}


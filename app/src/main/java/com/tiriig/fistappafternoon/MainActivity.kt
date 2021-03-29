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

    private lateinit var mybutton: Button
    private lateinit var myTextView: TextView
    private lateinit var name: TextView
    private lateinit var phone: TextView
    private lateinit var myEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mybutton = findViewById(R.id.myButton)
        myEditText = findViewById(R.id.myEditText)


        name = findViewById(R.id.name)
        phone = findViewById(R.id.phone)

        mybutton.setOnClickListener {

            Thread{

                val database = ProjectDatabase.invoke(this)

                //Deleting user
                database.userDao().deleteUser(1)

                //Updating user
                database.userDao().updateUser("Updated Name",2)

                val data = database.userDao().getAllUsers()

                runOnUiThread {
                    name.text = data.toString()
                }

            }.start()
        }
    }

}


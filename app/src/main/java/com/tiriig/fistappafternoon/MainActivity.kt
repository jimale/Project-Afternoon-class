package com.tiriig.fistappafternoon

import android.content.Intent
import android.os.Bundle
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

                val db = Room.databaseBuilder(applicationContext,
                        ProjectDatabase::class.java,
                        "projectDatabase").build()


                val userDao = db.userDao()

                //INSERT SINGLE  USER TO THE DATABASE
//                val user = User(1,"Axmed","Ali")
//                userDao.insert(user)

                //INSERT MULTIPLE USERS TO THE DATABASE
                val users = ArrayList<User>()
                users.add(User(2,"jama","mohamed"))
                users.add(User(3,"cilmi","xasan"))
                users.add(User(4,"warfa","mohamed"))
                users.add(User(5,"mohamed","mohamed"))

                userDao.insertUsers(users)


            }.start()

        }
    }

}


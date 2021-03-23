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

//            val name = myEditText.text
//
//            val toast = Toast.makeText(this, name, Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
//            toast.show()

//            val ab = Intent(this,DisplayActivity::class.java)
//            ab.putExtra("name",myEditText.text.toString())
//            startActivity(ab)

            Thread{

                val db = Room.databaseBuilder(applicationContext,
                        MyDatabase::class.java,
                        "mydatabase").build()

                val userDao  = db.userDao()

                //INSERTING SINGLE USER TO THE DATABASE
//                val user = User(1,"Mohamed",47838392)
//                userDao.insertUser(user)

                //INSERTING MULTIPLE USERS TO THE DATABASE
                val user = ArrayList<User>()
                user.add(User(2,"Jamac",232423))
                user.add(User(3,"Cali",4353534))
                user.add(User(4,"Xasan",8534354))
                user.add(User(5,"Casha",5439845))

                userDao.insertUsers(user)

            }.start()

        }

        val read = findViewById<Button>(R.id.read)

        read.setOnClickListener {
            readUser()
        }
    }


    fun readUser(){
        Thread{

            val db = Room.databaseBuilder(applicationContext,
                    MyDatabase::class.java,
                    "mydatabase").build()

            val userDao  = db.userDao()

            val user = userDao.getUser(5)

            runOnUiThread(Runnable {
                name.text = user.name
                phone.text = user.phone.toString()
            })

        }.start()
    }
}


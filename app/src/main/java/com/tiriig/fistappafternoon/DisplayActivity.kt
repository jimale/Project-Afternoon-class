package com.tiriig.fistappafternoon

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DisplayActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = DisplayAdapter()

    private val users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        val data = ArrayList<User>()
        data.add(User(1,"Ahmed ALi Jama","5754848","ahmed@gmail.com"))
        data.add(User(2,"Mohamed ALi Jama","435938","mohamed@gmail.com"))
        data.add(User(3,"Jama ALi Jama","837393","jama@gmail.com"))

        Thread{
            //INSERT
            val db = ProjectDatabase.invoke(this)
            //db.userDao().insert(data)

            //SELECT
            val usersData = db.userDao().getUsers()
            users.addAll(usersData)
        }.start()


        recyclerView = findViewById(R.id.displayRecyclerView)
        adapter.submitList(users)
        recyclerView.adapter = adapter
    }

}
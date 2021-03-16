package com.tiriig.fistappafternoon

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var language : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val spinner = findViewById<Spinner>(R.id.mySpinner)
        val myText = findViewById<TextView>(R.id.displayText)

        val languages = arrayOf("Select language","PHP","Java","Kotlin")

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,languages)

        spinner.adapter = adapter

        //click listener of the spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                myText.text = languages[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

//        textView = findViewById(R.id.displayText)
//
//        textView.text = intent.getStringExtra("name")
//
//        title = intent.getStringExtra("name")
    }

}
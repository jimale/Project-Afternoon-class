package com.tiriig.fistappafternoon

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mybutton: Button
    private lateinit var myTextView: TextView
    private lateinit var myEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView = findViewById(R.id.name)
        mybutton = findViewById(R.id.myButton)
        myEditText = findViewById(R.id.myEditText)

        mybutton.setOnClickListener {

            val name = myEditText.text

            val toast = Toast.makeText(this, name, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
            toast.show()


        }
    }
}


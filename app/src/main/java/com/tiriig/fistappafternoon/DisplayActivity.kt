package com.tiriig.fistappafternoon

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        textView = findViewById(R.id.displayText)

        textView.text = intent.getStringExtra("name")

        title = intent.getStringExtra("name")
    }

}
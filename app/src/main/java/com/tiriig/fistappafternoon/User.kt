package com.tiriig.fistappafternoon

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fullName : String,
    val phoneNumber : String,
    val email: String
)
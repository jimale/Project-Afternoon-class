package com.tiriig.fistappafternoon

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}
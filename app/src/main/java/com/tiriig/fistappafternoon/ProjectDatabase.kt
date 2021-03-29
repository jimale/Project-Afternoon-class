package com.tiriig.fistappafternoon

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class ProjectDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var instance: ProjectDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                ProjectDatabase::class.java, "projectDatabase")
                .build()
    }
}
package com.tiriig.fistappafternoon

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<User>)

    @Query("SELECT * FROM user")
    fun getUsers(): List<User>
}
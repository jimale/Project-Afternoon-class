package com.tiriig.fistappafternoon

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Insert
    fun insertUsers(user: List<User>)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user where id  = :userId")
    fun getUser(userId: Int): User
}
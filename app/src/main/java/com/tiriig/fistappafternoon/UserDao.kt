package com.tiriig.fistappafternoon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertUsers(user: List<User>)

    @Query("SELECT * FROM user Where id IN (:userId)")
    fun getUser(userId: Int): User
}
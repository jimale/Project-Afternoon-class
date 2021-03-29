package com.tiriig.fistappafternoon

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(user: List<User>)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user where id  = :userId")
    fun getUser(userId: Int): User

    @Query("DELETE FROM user where id = :userId")
    fun deleteUser(userId: Int)

    @Query("UPDATE user set firstName = :firstName where id = :userId")
    fun updateUser(firstName: String,userId: Int)
}
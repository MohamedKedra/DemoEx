package com.example.demoex

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMessage(message: Message)

    @Query("SELECT * from messages_Tb")
    fun getAllMessages() : LiveData<List<Message>>
}
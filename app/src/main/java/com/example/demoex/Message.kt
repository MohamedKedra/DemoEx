package com.example.demoex

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages_Tb")
class Message(var message: String,var userId: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
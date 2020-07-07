package com.example.demoex

import androidx.room.Entity
import androidx.room.PrimaryKey


class User(messages : ArrayList<Message>){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
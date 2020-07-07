package com.example.demoex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dao: ChatDao
    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ChatAdapter()
        rv_messages.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        dao = ChatDatabase.getDatabase(this).chatDao()

        initMessages()

        btn_send.setOnClickListener {
            val text = et_message.text.toString()
            if (text.isNotEmpty()) {
                val message = Message(text, 1)
                dao.insertMessage(message)
                adapter.addMessage(message)

                rv_messages.adapter = adapter
                et_message.setText("")
            } else {
                Toast.makeText(this, "Enter your message", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initMessages() {

        dao.getAllMessages().observe(this, Observer {
            if (it.isNotEmpty()) {
                rv_messages.visibility = View.VISIBLE
                tv_no_data.visibility = View.GONE
                adapter.setMessages(it)

                rv_messages.adapter = adapter
            }else{
                rv_messages.visibility = View.GONE
                tv_no_data.visibility = View.VISIBLE
            }
        })
    }


}
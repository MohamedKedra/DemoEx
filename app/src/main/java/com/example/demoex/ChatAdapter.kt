package com.example.demoex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message.view.*

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.MessageHolder>() {

    private var messages : ArrayList<Message> = ArrayList()

    inner class  MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        return MessageHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_message,parent,false))
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.itemView.tv_message.text = messages[position].message
    }

    fun setMessages(messages : List<Message>){
        this.messages = messages as ArrayList<Message>
        notifyDataSetChanged()
    }

    fun addMessage(message: Message){
        messages.add(message)
        notifyDataSetChanged()
    }
}
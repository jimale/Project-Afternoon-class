package com.tiriig.fistappafternoon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DisplayAdapter : ListAdapter<User,DisplayAdapter.ViewHolder>(DisplayDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DisplayAdapter.ViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        var currentUser : User? = null

        val name : TextView = itemView.findViewById(R.id.name)
//        val phone : TextView = itemView.findViewById(R.id.phone)
//        val email : TextView = itemView.findViewById(R.id.email)

        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"Phone Number is ${currentUser?.phoneNumber}",Toast.LENGTH_LONG).show()
            }
        }

        fun bind(user: User){
            name.text = user.fullName
//            phone.text = user.phoneNumber
//            email.text = user.email
            currentUser = user
        }
    }

    class DisplayDiffCallback : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }
}
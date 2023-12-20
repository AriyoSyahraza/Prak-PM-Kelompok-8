package com.example.prakpmkel8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val listener: MainActivity) : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    interface OnItemClickListener {
        fun onUpdateClick(user: User)
        fun onDeleteClick(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewOperator: TextView = itemView.findViewById(R.id.textViewOperator)
        private val textViewLocation: TextView = itemView.findViewById(R.id.textViewLocation)
        private val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)

        fun bind(user: User) {
            textViewName.text = "Name: ${user.name ?: "N/A"}"
            textViewOperator.text = "Operator: ${user.operator ?: "N/A"}"
            textViewLocation.text = "Location: ${user.location ?: "N/A"}"
            textViewPhone.text = "Phone: ${user.phone ?: "N/A"}"
        }
    }

    private class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.phone == newItem.phone
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}
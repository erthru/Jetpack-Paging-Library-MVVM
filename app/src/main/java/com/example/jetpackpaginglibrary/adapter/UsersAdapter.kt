package com.example.jetpackpaginglibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpackpaginglibrary.R
import com.example.jetpackpaginglibrary.models.User
import kotlinx.android.synthetic.main.list_users.view.*

class UsersAdapter : PagedListAdapter<User, UsersAdapter.ViewHolder>(USER_COMPARATOR){
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = newItem == oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_users, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    class ViewHolder(val v: View) : RecyclerView.ViewHolder(v){
        fun bind(user: User){
            Glide.with(v.context).load(user.avatar).into(v.imgLU)
            v.tvFullNameLU.text = "${user.firstName} ${user.lastName}"
            v.tvEmailLU.text = user.email
        }
    }
}
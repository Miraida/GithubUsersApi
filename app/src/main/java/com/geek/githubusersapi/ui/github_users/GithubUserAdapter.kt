package com.geek.githubusersapi.ui.github_users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geek.githubusersapi.R
import com.geek.githubusersapi.databinding.ItemGithubUserBinding
import com.geek.githubusersapi.extension.loadImage
import com.geek.githubusersapi.model.GithubUser

class GithubUserAdapter : RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {

    private var list = ArrayList<GithubUser>()

    internal fun updateList(list: ArrayList<GithubUser>) {
        this.list.clear()
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val ui = ItemGithubUserBinding.bind(view)

        fun onBind(githubUserItem: GithubUser) {
            githubUserItem.avatar_url?.let { ui.itemIv.loadImage(it) }
            ui.itemTvLogin.text = githubUserItem.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_github_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
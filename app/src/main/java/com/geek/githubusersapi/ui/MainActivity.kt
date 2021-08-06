package com.geek.githubusersapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geek.githubusersapi.R
import com.geek.githubusersapi.ui.github_users.GithubUsersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,GithubUsersFragment()).commit()
    }
}
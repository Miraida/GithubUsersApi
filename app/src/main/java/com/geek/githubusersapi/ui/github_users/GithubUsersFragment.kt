package com.geek.githubusersapi.ui.github_users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geek.githubusersapi.core.network.Status
import com.geek.githubusersapi.databinding.GithubUsersFragmentBinding
import com.geek.githubusersapi.extension.visibility
import com.geek.githubusersapi.model.GithubUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubUsersFragment : Fragment() {

    private val viewModel: GithubUsersViewModel by viewModel()
    private lateinit var ui: GithubUsersFragmentBinding
    private val adapter: GithubUserAdapter by lazy { GithubUserAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ui = GithubUsersFragmentBinding.inflate(layoutInflater)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        setupListeners()
    }

    private fun setupUi() {
        ui.rvGithubUser.adapter = adapter
    }

    private fun setupListeners() {

        viewModel.loading.observe(requireActivity(), {
            ui.progress.visibility(it)
        })

        viewModel.fetchGithubUsers().observe(requireActivity(), {
            when (it.status) {
                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
                Status.SUCCESS -> {
                    if (it.data != null) {
                        viewModel.loading.postValue(false)
                        adapter.updateList(it.data as ArrayList<GithubUser>)
                    }
                }
                Status.ERROR -> {
                    viewModel.loading.postValue(false)
                    Log.d("TAG", "setupListeners: " + it.msg + " code: " + it.code)
                }
            }
        })
    }
}
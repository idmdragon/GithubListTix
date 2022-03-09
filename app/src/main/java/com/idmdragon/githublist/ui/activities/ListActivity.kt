package com.idmdragon.githublist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.idmdragon.githublist.BaseApplication
import com.idmdragon.githublist.data.Resource
import com.idmdragon.githublist.databinding.ActivityListBinding
import com.idmdragon.githublist.ui.adapter.ListAdapter
import com.idmdragon.githublist.ui.viewModels.ListViewModel
import com.idmdragon.githublist.ui.viewModels.ViewModelFactory
import javax.inject.Inject

class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: ListViewModel by viewModels { factory }
    private lateinit var binding: ActivityListBinding
    private val adapter by lazy {
        ListAdapter().apply {
            onUserClickListener = { username ->
                viewModel.getDetailUser(username).observe(this@ListActivity){ resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            showProgressBar(true)
                        }
                        is Resource.Success -> {
                            resource.data?.let { items ->
                                val dataToast = """
                                    Name  = ${items.username}
                                    Email = ${items.email}
                                    Bergabung pada = ${items.createdDate}
                                """.trimIndent()
                                Toast.makeText(this@ListActivity,dataToast,Toast.LENGTH_LONG).show()
                            }
                            showProgressBar(false)
                        }
                        is Resource.Error -> {
                            showProgressBar(false)
                            Snackbar.make(
                                binding.root,
                                resource.message.toString(),
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as BaseApplication).appComponent.inject(this)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupObserver()
    }

    private fun setupView() {
        binding.apply {
            adapter.setItems(listOf())
            rvListUser.adapter = adapter
        }
    }

    private fun setupObserver(){
        viewModel.getListUser().observe(this){ resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.rvListUser.isVisible = false
                    showProgressBar(true)
                }
                is Resource.Success -> {
                    resource.data?.let { items ->
                        adapter.setItems(items)
                        binding.rvListUser.adapter = adapter
                    }
                    binding.rvListUser.isVisible = true
                    showProgressBar(false)
                }
                is Resource.Error -> {
                    showProgressBar(false)
                    Snackbar.make(
                        binding.root,
                        resource.message.toString(),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun showProgressBar(isVisible: Boolean){
        binding.progressBar.isVisible = isVisible
    }
}
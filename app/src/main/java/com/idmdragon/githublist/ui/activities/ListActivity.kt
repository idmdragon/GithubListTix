package com.idmdragon.githublist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idmdragon.githublist.R
import com.idmdragon.githublist.databinding.ActivityListBinding
import com.idmdragon.githublist.ui.adapter.ListAdapter
import com.idmdragon.githublist.utils.DummyData

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private var adapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.apply {
            adapter.setItems(DummyData.generateList())
            rvListUser.adapter = adapter
        }
    }
}
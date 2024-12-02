package com.brain.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brain.adapter.adapter.MyAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Sample data
        val items = mutableListOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter = MyAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

// Update an item programmatically
        adapter.updateItem(2, "Updated Item 2") // Updates the second item

    }
}

package com.brain.adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brain.adapter.R

class MyAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]

        // Example: Deleting an item when clicked (optional)
        holder.itemView.setOnClickListener {
            deleteItem(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Deletes an item at the given position and notifies the adapter
     */
    private fun deleteItem(position: Int) {
        if (position in items.indices) { // Ensure the position is valid
            items.removeAt(position) // Remove the item from the list
            notifyItemRemoved(position) // Notify the adapter about the removal
            notifyItemRangeChanged(position, items.size) // Update the remaining items
        }
    }

    /**
     * Updates an item at the given position with new data and notifies the adapter
     */
    fun updateItem(position: Int, newItem: String) {
        if (position in items.indices) { // Ensure the position is valid
            items[position] = newItem // Update the item in the list
            notifyItemChanged(position) // Notify the adapter about the change
        }
    }
}

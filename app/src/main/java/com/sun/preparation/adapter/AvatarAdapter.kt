package com.sun.preparation.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.preparation.R
import com.sun.preparation.data.Avatar

class AvatarAdapter(
    private val context: Context,
    private val gridItems: List<Avatar>,
    private val onItemClick: (Int, Avatar) -> Unit
) : RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder>() {
    private var selectedPosition = RecyclerView.NO_POSITION // Default value for no selection

    inner class AvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.avatarImageView)

        init {
            // Handle item click
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    if (selectedPosition != position) {
                        // Update selected position
                        val previousSelected = selectedPosition
                        selectedPosition = position

                        // Notify items to be rebind
                        notifyItemChanged(previousSelected)
                        notifyItemChanged(selectedPosition)

                        // Handle item click
                        onItemClick(position, gridItems[position])
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_avatar, parent, false)
        return AvatarViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        val currentItem = gridItems[position]
        Glide.with(context).load(currentItem.image).into(holder.imageView)

        // Apply color blur effect to the selected item
        if (position == selectedPosition) {
            holder.itemView.setBackgroundColor(
                context.resources.getColor(R.color.selectedItemOverlayColor)
            )
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return gridItems.size
    }
}

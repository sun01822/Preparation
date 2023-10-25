package com.sun.preparation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sun.preparation.R
import com.sun.preparation.data.Subject

class SubjectAdapter(private val subjects: List<Subject>) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(subject: Subject)
    }

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.subjectName)
        val subjectImage: ImageView = itemView.findViewById(R.id.subjectImage)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val progressText: TextView = itemView.findViewById(R.id.progressText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subject_layout, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjects[position]
        holder.subjectName.text = subject.name
        holder.subjectImage.setImageResource(subject.iconResId)

        // Set progress values
        holder.progressBar.progress = subject.progress.toInt()

        // Set progress text
        holder.progressText.text = "You completed " + holder.progressBar.progress.toString() + "%"

        // Set the progress bar color based on a condition
        val progressBarDrawable = when {
            subject.progress >= 70.0 -> ContextCompat.getDrawable(holder.progressBar.context, R.drawable.custom_progress_bar2)
            subject.progress >= 30.0 -> ContextCompat.getDrawable(holder.progressBar.context, R.drawable.custom_progress_bar3)
            else -> ContextCompat.getDrawable(holder.progressBar.context, R.drawable.custom_progress_bar1)
        }
        holder.progressBar.progressDrawable = progressBarDrawable

        // Set the item click listener
        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(subject)
        }
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }
}

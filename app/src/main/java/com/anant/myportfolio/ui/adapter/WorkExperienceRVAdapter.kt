package com.anant.myportfolio.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anant.myportfolio.R
import com.anant.myportfolio.data.resume.Work
import kotlinx.android.synthetic.main.work_child_item.view.*

class WorkExperienceRVAdapter(
    private val context: Context?,
    private val workExListDataItems: ArrayList<Work>
) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return workExListDataItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.work_child_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItemId(position).let {
            holder.itemView.CompanyTextView.text = workExListDataItems[position].company
            holder.itemView.locationTextView.text = workExListDataItems[position].location
            holder.itemView.startDateTextView.text = workExListDataItems[position].startDate
            holder.itemView.endDateTextView.text = workExListDataItems[position].endDate
            holder.itemView.roleTextView.text = workExListDataItems[position].position
            holder.itemView.dutiesTextView.text = getJobDuties(workExListDataItems[position].highlights)
        }
    }

    private fun getJobDuties(duties: ArrayList<String?>?): String {

        if (duties.isNullOrEmpty()) return ""
        var combinedDuties: String = ""
        for (duty in duties) {
            combinedDuties = combinedDuties + '\n' + duty
        }
        return combinedDuties
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each item to
}
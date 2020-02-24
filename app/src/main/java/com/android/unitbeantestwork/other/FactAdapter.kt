package com.android.unitbeantestwork.other

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.android.unitbeantestwork.Contract
import com.android.unitbeantestwork.R

class FactAdapter(private val facts: ArrayList<Fact>, private val mView: Contract.MainView): RecyclerView.Adapter<FactAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = facts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.body.text = facts[position].text
        val title = "CatFact №${position + 1}"
        holder.title.text = title
        when(facts[position].upVotes > 0) {
            true -> holder.votes.setTextColor(Color.parseColor("#8000FF00"))
            false -> holder.votes.setTextColor(Color.parseColor("#CCFF0000"))
        }
        holder.votes.text = facts[position].upVotes.toString()
        val name = "${facts[position].user.name.first} ${facts[position].user.name.last}"
        holder.name.text = name

        holder.item.setOnClickListener {
            mView.showDetail()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.list_title)
        val body: TextView = itemView.findViewById(R.id.list_body)
        val votes: TextView = itemView.findViewById(R.id.list_votes)
        val name: TextView = itemView.findViewById(R.id.list_name)
        val item: CardView = itemView.findViewById(R.id.factCardView)
    }
}
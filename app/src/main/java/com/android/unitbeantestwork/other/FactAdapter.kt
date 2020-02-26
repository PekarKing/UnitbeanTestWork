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
        facts[position].factNumber = "CatFact №${position + 1}"
        when(facts[position].upVotes > 0) {
            true -> holder.votes.setTextColor(Color.parseColor("#00aa00"))
            false -> holder.votes.setTextColor(Color.parseColor("#dd0000"))
        }

        val name = "${facts[position].user.name.first} ${facts[position].user.name.last}"
        holder.name.text = name
        holder.votes.text = facts[position].upVotes.toString()
        holder.body.text = when(facts[position].text.length > 190){
            true -> "   ${facts[position].text.substring(0, 190)}..."
            false -> "  ${facts[position].text}"
        }
        holder.title.text = facts[position].factNumber
        holder.item.setOnClickListener {
            mView.showDetail(facts[position])
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.list_title)
        val body: TextView = itemView.findViewById(R.id.list_body)
        val votes: TextView = itemView.findViewById(R.id.list_votes)
        val name: TextView = itemView.findViewById(R.id.list_name)
//        val date: TextView = itemView.findViewById(R.id.list_date)
        val item: CardView = itemView.findViewById(R.id.factCardView)
    }
}
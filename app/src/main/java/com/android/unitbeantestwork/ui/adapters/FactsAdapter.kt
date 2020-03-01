package com.android.unitbeantestwork.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.android.unitbeantestwork.R
import com.android.unitbeantestwork.mvp.model.Fact
import com.android.unitbeantestwork.mvp.views.MainView

class FactsAdapter(private val facts: List<Fact>, private val mView: MainView): RecyclerView.Adapter<FactsAdapter.ViewHolder>()  {

    override fun getItemCount() = facts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val fact = facts[i]
        fact.factNumber = "CatFact №${i + 1}"
//        when(fact.upVotes > 0) {
//            true -> holder.votes.setTextColor(ContextCompat.getColor(MainActivity.getContext(), R.color.colorGreen))
//            false -> holder.votes.setTextColor(ContextCompat.getColor(MainActivity.getContext(), R.color.colorRed))
//        }
        holder.votes.text = fact.upVotes.toString()
        val name = "${fact.user.name.first} ${fact.user.name.last}"
        holder.name.text = name
        holder.body.text = when(fact.text.length > 190){
            true -> "   ${fact.text.substring(0, 190)}..."
            false -> "  ${fact.text}"
        }
        holder.title.text = fact.factNumber
        holder.item.setOnClickListener {
            mView.openDetailScreen(fact)
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
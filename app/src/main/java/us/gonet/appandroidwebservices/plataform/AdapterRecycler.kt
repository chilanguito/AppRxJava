package us.gonet.appandroidwebservices.plataform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_detail.view.*
import us.gonet.appandroidwebservices.R
import us.gonet.appandroidwebservices.data.models.ModelCrime

class AdapterRecycler(private var list: ArrayList<ModelCrime>) : RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var date: TextView = itemView.fecha
        private var rangeAge: TextView = itemView.rango_edad
        private var gender: TextView = itemView.genero
        private var etnia: TextView = itemView.etnia

        fun bind(list: ArrayList<ModelCrime>) {
            date.text = list[adapterPosition].datetime
            rangeAge.text = list[adapterPosition].age_range
            gender.text = list[adapterPosition].gender
            etnia.text = list[adapterPosition].self_defined_ethnicity
        }
    }
}
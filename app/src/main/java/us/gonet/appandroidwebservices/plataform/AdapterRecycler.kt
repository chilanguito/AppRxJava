package us.gonet.appandroidwebservices.plataform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import us.gonet.appandroidwebservices.R
import us.gonet.appandroidwebservices.data.models.ModelCrime

class AdapterRecycler(private var list: ArrayList<ModelCrime>) : RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var fecha: TextView = view.findViewById(R.id.fecha)
        private var rangoEdad: TextView = view.findViewById(R.id.rango_edad)
        private var genero: TextView = view.findViewById(R.id.genero)
        private var etnia: TextView = view.findViewById(R.id.etnia)

        fun bind(lista:ArrayList<ModelCrime>) {
            fecha.text= lista[adapterPosition].datetime
            rangoEdad.text= lista[adapterPosition].age_range
            genero.text= lista[adapterPosition].gender
            etnia.text= lista[adapterPosition].self_defined_ethnicity
        }
    }
}
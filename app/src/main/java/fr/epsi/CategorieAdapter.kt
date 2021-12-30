package fr.epsi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategorieAdapter(val categorie : ArrayList<Categorie>): RecyclerView.Adapter<CategorieAdapter.ViewHolder>() {

    class ViewHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        val button = view.findViewById<Button>(R.id.button_rayon)
        var categorie : Categorie? = null

        init {
            button.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val newIntent = Intent(context,ProduitListeActivity::class.java)
            newIntent.putExtra("title", categorie?.title)
            newIntent.putExtra("url", categorie?.product_url)
            ContextCompat.startActivity(context, newIntent, null)
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val category = categorie.get(position)
        holder.button.text = category.title
        holder.categorie = category
    }

    override fun getItemCount(): Int {
        return categorie.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rayons, viewGroup, false)

        return ViewHolder(viewGroup.context,view)
    }
}
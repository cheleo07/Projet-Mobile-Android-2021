package fr.epsi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProduitAdapter (val produit : ArrayList<Produit>): RecyclerView.Adapter<ProduitAdapter.ViewHolder>() {

    class ViewHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
        var description = view.findViewById<TextView>(R.id.description)
        val name = view.findViewById<TextView>(R.id.productName)
        var produit : Produit? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val newIntent = Intent(context,ProduitDetailActivity::class.java)
            newIntent.putExtra("title", produit?.name)
            newIntent.putExtra("url", produit?.picture_url)
            newIntent.putExtra("description",produit?.description)
            ContextCompat.startActivity(context, newIntent, null)
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = produit.get(position)
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.description.text = product.description
        holder.name.text = product.name
        holder.produit = product

    }

    override fun getItemCount(): Int {
        return produit.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.produits, viewGroup, false)

        return ViewHolder(viewGroup.context,view)
    }
}
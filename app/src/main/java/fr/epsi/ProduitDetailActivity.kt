package fr.epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProduitDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit_detail)
        showBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        val picture_url = intent.getStringExtra("url")
        val description = intent.getStringExtra("description")

        val imageViewProduct = findViewById<ImageView>(R.id.imageViewProductDetail)
        var descriptionTextView = findViewById<TextView>(R.id.descriptionDetailProduct)

        Picasso.get().load(picture_url).into(imageViewProduct)
        descriptionTextView.text = description
    }
}
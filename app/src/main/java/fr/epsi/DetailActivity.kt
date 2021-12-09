package fr.epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showBack()
        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        val urlImage = intent.getStringExtra("urlImage")
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        Picasso.get().load(urlImage).into(imageView)
    }
}
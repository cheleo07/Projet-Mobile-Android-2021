package fr.epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class StudentInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        showBack()
        setupHyperlink()
        val imageView = findViewById<ImageView>(R.id.imageAvatar)
        val urlImage = intent.getStringExtra("urlImage")
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        Picasso.get().load(urlImage).into(imageView)
    }
}
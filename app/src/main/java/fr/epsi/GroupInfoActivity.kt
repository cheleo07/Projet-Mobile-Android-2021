package fr.epsi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        showBack()
        var btnEtudiant = findViewById<Button>(R.id.BtnEtudiant)

        btnEtudiant.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,StudentInfoActivity::class.java)
            newIntent.putExtra("title","Infos Etudiant")
            newIntent.putExtra("urlImage","https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-Vector-PNG-File.png")
            startActivity(newIntent)
        })

        /*val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        val urlImage = intent.getStringExtra("urlImage")
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        Picasso.get().load(urlImage).into(imageView)*/
        setHeaderTitle("Infos")

    }
}
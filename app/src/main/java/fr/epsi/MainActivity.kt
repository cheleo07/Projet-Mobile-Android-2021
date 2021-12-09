package fr.epsi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNature = findViewById<Button>(R.id.btnNature)
        var btnEspace = findViewById<Button>(R.id.btnEspace)

        btnNature.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title","Nature")
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROFiHOkKUHVBF3TcyU1NgawBlIV9mIoSGAuA&usqp=CAU")
            startActivity(newIntent)
        })

        btnEspace.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title","Espace")
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj0AEwRdUSWfs2LPDlLKn9kI-KvverDKfy0w&usqp=CAU")
            startActivity(newIntent)
        })
        setHeaderTitle("Main")

    }
}
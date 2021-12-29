package fr.epsi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var btnZone1 = findViewById<Button>(R.id.BtnZone1)
        var btnZone2 = findViewById<Button>(R.id.BtnZone2)

        btnZone1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupInfo::class.java)
            newIntent.putExtra("title","Infos")
            startActivity(newIntent)
        })

        btnZone2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupInfo::class.java)
            newIntent.putExtra("title","Rayons")
            startActivity(newIntent)
        })

        /*btnZone1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupInfo::class.java)
            newIntent.putExtra("title","Infos")
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROFiHOkKUHVBF3TcyU1NgawBlIV9mIoSGAuA&usqp=CAU")
            startActivity(newIntent)
        })

        btnZone2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupInfo::class.java)
            newIntent.putExtra("title","Rayons")
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRj0AEwRdUSWfs2LPDlLKn9kI-KvverDKfy0w&usqp=CAU")
            startActivity(newIntent)
        })*/
        setHeaderTitle("Epsi")

    }
}
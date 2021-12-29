package fr.epsi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

open class BaseActivity : AppCompatActivity() {
    fun showBack(){
        val imageViewBack = findViewById<Button>(R.id.btnViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    fun setHeaderTitle(text:String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text=text
    }

    fun setupHyperlink(){
        val linkTextView = findViewById<TextView>(R.id.EpsiLink)
        linkTextView.movementMethod = LinkMovementMethod.getInstance()
        linkTextView.setLinkTextColor(Color.BLUE)
    }


}
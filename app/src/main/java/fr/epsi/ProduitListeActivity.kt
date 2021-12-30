package fr.epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProduitListeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit_liste)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProduct)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val products = arrayListOf<Produit>()
        val productAdapter = ProduitAdapter(products)
        recyclerView.adapter=productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL= intent.getStringExtra("url")
        val request = mRequestURL?.let {
            Request.Builder()
                .url(it)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        }

        if (request != null) {
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("error","erreur")
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = response.body()?.string()

                    if(data!=null){
                        val jsProducts = JSONObject(data)
                        val jsArrayProduct = jsProducts.getJSONArray("items")
                        for(i in 0 until jsArrayProduct.length()){
                            val jsProduct = jsArrayProduct.getJSONObject(i)
                            val product = Produit(jsProduct.optString("name",""),
                                jsProduct.optString("description",""),
                                jsProduct.optString("picture_url",""))
                            products.add(product)
                        }
                    }
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })
                }
            })
        }
    }
}
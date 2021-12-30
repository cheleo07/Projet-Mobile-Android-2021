package fr.epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategorieActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle("Rayons")
        showBack();

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategory)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categories = arrayListOf<Categorie>()
        val categoryAdapter = CategorieAdapter(categories)
        recyclerView.adapter=categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("error","erreur")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()

                if(data!=null){
                    val jsCategories = JSONObject(data)
                    val jsArrayCategory = jsCategories.getJSONArray("items")
                    for(i in 0 until jsArrayCategory.length()){
                        val jsCategory = jsArrayCategory.getJSONObject(i)
                        val category = Categorie(jsCategory.optString("category_id",""),
                            jsCategory.optString("title",""),
                            jsCategory.optString("products_url",""))
                        categories.add(category)
                    }
                }
                runOnUiThread(Runnable {
                    categoryAdapter.notifyDataSetChanged()
                })
            }
        })

    }
}
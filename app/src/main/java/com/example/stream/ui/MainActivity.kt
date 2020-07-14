package com.example.stream.ui

import Items
import Json4Kotlin_Base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.videostreaming.network.FetchData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stream.R
import com.example.stream.VideosComponent
import com.example.stream.adapter.BaseAdapter



class MainActivity : AppCompatActivity() {

    var recyclerview:RecyclerView?=null
    var layoutmanager:LinearLayoutManager?=null
    var baseadapter:BaseAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recycler)
        layoutmanager = LinearLayoutManager(this@MainActivity)
        callingApi()
    }

    private fun callingApi() {

        val request= FetchData.Service.buildService(VideosComponent::class.java)
        val call=request.getmov("contentDetails","mostPopular","IN","25",
            "AIzaSyBATzbcqD_U_g9E0ochx6FEIUdsts4yn_8","IwAR2QWdxrqt25gfHaGxsOLHjxilTzsTalvELaLMX0yT_20VN3iDYbL0xT-fI");
        call.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(call: Call<Json4Kotlin_Base>, response: Response<Json4Kotlin_Base>) {
                baseadapter=BaseAdapter(this@MainActivity, response.body()?.items as ArrayList<Items>)
                recyclerview?.layoutManager=layoutmanager
                recyclerview?.adapter=baseadapter
            }
            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {}
        })

    }
}

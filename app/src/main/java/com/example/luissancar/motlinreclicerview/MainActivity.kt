package com.example.luissancar.motlinreclicerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getGuitars(), this)
        mRecyclerView.adapter = mAdapter

    }


    fun getGuitars(): MutableList<Guitars>{
        var guitarss:MutableList<Guitars> = ArrayList()
        guitarss.add(Guitars("Fender", "Stratocaster", "https://www.fmicassets.com/Damroot/ZoomJpg/10002/0137002321_gtr_frt_001_rr.jpg"))
        guitarss.add(Guitars("Gibson", "Les Paul", "https://i.ebayimg.com/images/g/lPYAAOSwGotWtkjl/s-l1600.jpg"))
        guitarss.add(Guitars("Fender", "Telecaster", "http://media.guitarcenter.com/is/image/MMGS7/Limited-Edition-American-Professional-Telecaster-with-Rosewood-Neck-Surf-Green/J56814000001000-00-500x500.jpg"))
        guitarss.add(Guitars("Gibson", "SG", "https://www.thomann.de/pics/prod/384980.jpg"))
        guitarss.add(Guitars("Guild ", "-150 Savoy Blonde", "https://www.thomann.de/pics/prod/305072.jpg"))

        return guitarss
    }

}

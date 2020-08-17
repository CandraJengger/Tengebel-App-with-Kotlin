package com.candra.tengebel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvTravel: RecyclerView
    private var list: ArrayList<Travel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTravel = findViewById(R.id.rv_tumbnails)
        rvTravel.setHasFixedSize(true)

        list.addAll(TravelsData.listData)
        showRecyclerList()

        val imgProfile: ImageView = findViewById(R.id.img_profile)
        imgProfile.setOnClickListener(this)
    }

    private fun showRecyclerList() {
        rvTravel.layoutManager = LinearLayoutManager(this)
        val listTravelAdapter = ListTravelAdapter(list)
        rvTravel.adapter =listTravelAdapter

        listTravelAdapter.setOnClickCallback(object: ListTravelAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Travel) {
                showDetailTravel(data)
            }
        })

    }

    /* Profile */

    override fun onClick(v: View) {
        if (v.id == R.id.img_profile) {
            val moveIntentProfile = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(moveIntentProfile)
        }
    }


    /* OnClick Detail */
    private fun showDetailTravel(travel: Travel) {
//        Toast.makeText(this, "Kamu memilih " + travel.name, Toast.LENGTH_SHORT).show()
        val moveDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveDataIntent.putExtra(DetailActivity.EXTRA_NAME, travel.name)
        moveDataIntent.putExtra(DetailActivity.EXTRA_ADDRESS, travel.address)
        moveDataIntent.putExtra(DetailActivity.EXTRA_INFO, travel.info)
        moveDataIntent.putExtra(DetailActivity.EXTRA_IMG, travel.photo)
        startActivity(moveDataIntent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }


}
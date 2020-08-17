package com.candra.tengebel


import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*

import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var name: String
    private lateinit var btnMark: Button

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_INFO = "extra_info"
        const val EXTRA_IMG = "extra_img"

        const val STATE_BTN = "state_btn"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_travel)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvAddress: TextView = findViewById(R.id.tv_item_adress)
        val tvInfo: TextView = findViewById(R.id.tv_item_info)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val address = intent.getStringExtra(EXTRA_ADDRESS)
        val info = intent.getStringExtra(EXTRA_INFO)
        val imgPositon = intent.getIntExtra(EXTRA_IMG, 0)


        tvName.text = name
        tvAddress.text = address
        tvInfo.text = info
        imgPhoto.setImageResource(imgPositon)

//      onClick button
        btnMark = findViewById(R.id.btn_mark)
        btnMark.setOnClickListener(this)
        setNameToToast(tvName.text.toString())

//        onClick arrow
        val icArrow: ImageView = findViewById(R.id.ic_arrow_back)
        icArrow.setOnClickListener(this)

//      declare anim

        val verticalFadeIn = AnimationUtils.loadAnimation(this, R.anim.vertical_fade_in)
        val scaleToBig = AnimationUtils.loadAnimation(this, R.anim.scale_to_big)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        tvName.startAnimation(verticalFadeIn)
        imgPhoto.startAnimation(scaleToBig)
        tvAddress.startAnimation(fadeIn)
        tvInfo.startAnimation(fadeIn)

//      onSave
        if (savedInstanceState != null) {
            val textBtn = savedInstanceState.getString(STATE_BTN) as String
            btnMark.text = textBtn

            if (btnMark.text == "Batal Menandai") {
                btnMark.setBackgroundDrawable(getResources().getDrawable(R.drawable.radius_red))
            } else {
                btnMark.setBackgroundDrawable(getResources().getDrawable(R.drawable.radius))
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_BTN, btnMark.text.toString())
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_mark -> {
                if (btnMark.text == "Batal Menandai") {
                    btnMark.text = "Tandai Sebagai Tujuan"
                    btnMark.setBackgroundDrawable(getResources().getDrawable(R.drawable.radius))
                    val toast = Toast.makeText(
                        this,
                        "Anda batal menandai ${getNameToToast()} sebagai tujuan",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                    toast.setGravity(Gravity.BOTTOM or Gravity.LEFT, 40, 90  )
                } else {
                    btnMark.text = "Batal Menandai"
                    btnMark.setBackgroundDrawable(getResources().getDrawable(R.drawable.radius_red))
                    val toast = Toast.makeText(
                        this,
                        "Anda menandai ${getNameToToast()} sebagai tujuan",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                    toast.setGravity(Gravity.BOTTOM or Gravity.LEFT, 40, 90  )

                }
            }

            R.id.ic_arrow_back -> {
                val backToMain = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(backToMain)
                finish()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
    }

    private fun setNameToToast(pName: String) {
        name = pName
    }

    private fun getNameToToast(): String {
        return name
    }



}
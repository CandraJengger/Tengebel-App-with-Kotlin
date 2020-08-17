package com.candra.tengebel

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //        onClick arrow
        val icArrow: ImageView = findViewById(R.id.ic_arrow_back)
        icArrow.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.ic_arrow_back) {
            val backToMain = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(backToMain)
            finish()
        }
    }


}
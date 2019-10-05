package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dash_button.setOnClickListener{

            startActivity(Intent(this,DashBoard::class.java))
        }

        val user : ArrayList<String> = ArrayList()

        for(i in 1..100)
        {
            user.add("my number is $i")
        }

        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = MyAdapter(user)
    }
}

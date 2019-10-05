package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_dash_board.*

class DashBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        var email : EditText = findViewById(R.id.email_id)
        var pass : EditText = findViewById(R.id.pass_id)
        var submit : Button = findViewById(R.id.submit_id)

        submit.setOnClickListener{

            saveData();
        }
    }

    private fun saveData() {

        val email : String = email_id.text.toString().trim()
        val pass : String = pass_id.text.toString().trim()

        var ref = FirebaseDatabase.getInstance().getReference("user")
        val uid : String = ref.push().key.toString()

        val user = User(uid,email,pass)

        ref.child(uid).setValue(user).addOnCompleteListener{

            Toast.makeText(applicationContext,"Added",Toast.LENGTH_LONG).show()
        }



    }
}

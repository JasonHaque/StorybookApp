package com.example.storybookapp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storybookapp.Activities.LogInActivity
import com.example.storybookapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile_view.*

class ProfileView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
        bindWidgets()
    }
    private fun bindWidgets(){
        profile_view.text= FirebaseAuth.getInstance().currentUser?.email.toString()
        log_out_button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this,"Logging out",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
    }
}

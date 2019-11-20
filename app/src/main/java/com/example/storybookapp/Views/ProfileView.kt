package com.example.storybookapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}

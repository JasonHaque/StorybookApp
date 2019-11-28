package com.example.storybookapp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.R
import kotlinx.android.synthetic.main.activity_home_view.*

class HomeView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)
        //Todo:Create a hamburger menu
        bindListeners()
    }
    private fun bindListeners(){
        Create_new_story.setOnClickListener {

        }
        Current_Stories.setOnClickListener {

        }
        goto_profile.setOnClickListener {
            val intent=Intent(this,ProfileView::class.java)
            startActivity(intent)
        }
    }
}

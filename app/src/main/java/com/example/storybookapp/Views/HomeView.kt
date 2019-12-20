package com.example.storybookapp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.Activities.CurrentStoriesActivity
import com.example.storybookapp.Activities.NewStoryActivity
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
            val intent=Intent(this,NewStoryActivity::class.java)
            startActivity(intent)
        }
        Current_Stories.setOnClickListener {
            val intent=Intent(this,CurrentStoriesActivity::class.java)
            startActivity(intent)
        }
        goto_profile.setOnClickListener {
            val intent=Intent(this,ProfileView::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}

package com.example.storybookapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_current_story_view.*

class CurrentStoryView : AppCompatActivity() {

    private var db = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_story_view)
        var strUser: String = intent.getStringExtra("StoryName")
        story_name_view.text = strUser
        bindListeners()
    }


    fun bindListeners(){
        go_back_to_new_Story.setOnClickListener {
            //Todo:Add an Activity
        }

    }
}

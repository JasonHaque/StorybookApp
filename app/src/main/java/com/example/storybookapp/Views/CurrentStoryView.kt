package com.example.storybookapp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.Activities.NewStoryActivity
import com.example.storybookapp.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_current_story_view.*

class CurrentStoryView : AppCompatActivity() {

    private var db = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_story_view)
        val strName: String = intent.getStringExtra("StoryName")
        val strDesc: String = intent.getStringExtra("StoryDesc")
        story_name_view.text = strName
        story_desc_view.text = strDesc
        bindListeners()
    }


    fun bindListeners(){
        go_back_to_new_Story.setOnClickListener {
            val intent = Intent(this,NewStoryActivity::class.java)
            startActivity(intent)
        }

    }
}

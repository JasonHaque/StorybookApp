package com.example.storybookapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.R
import kotlinx.android.synthetic.main.activity_new_story.*

class NewStoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_story)
        bindWidgets()
    }

    private fun bindWidgets(){
        save_story.setOnClickListener {
            //TODO: add listener
        }
    }
}

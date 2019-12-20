package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.R
import com.example.storybookapp.Views.HomeView
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
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@NewStoryActivity, HomeView::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()

    }
}

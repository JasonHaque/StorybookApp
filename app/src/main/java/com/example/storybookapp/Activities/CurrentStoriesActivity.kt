package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storybookapp.R
import com.example.storybookapp.Views.HomeView

class CurrentStoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_stories)
        //TODO:: implement recycler view
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@CurrentStoriesActivity, HomeView::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()

    }
}

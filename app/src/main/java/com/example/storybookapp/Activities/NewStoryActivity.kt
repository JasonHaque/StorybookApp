package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storybookapp.Classes.StoryData
import com.example.storybookapp.R
import com.example.storybookapp.Views.CurrentStoryView
import com.example.storybookapp.Views.HomeView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_story.*

class NewStoryActivity : AppCompatActivity() {

    private var db =FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_story)
        bindWidgets()
    }

    private fun bindWidgets(){
        save_story.setOnClickListener {
            val StoryName = Name_of_Story.text.toString()
            val StoryDesc = Story_Description.text.toString()
            if(StoryName.isEmpty() || StoryDesc.isEmpty()){
                Toast.makeText(this,"Enter a story please",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val storyData =StoryData(FirebaseAuth.getInstance().currentUser?.uid.toString(),StoryName,StoryDesc)
            db.child("Users").child("Stories")
                .child(FirebaseAuth.getInstance().currentUser?.uid.toString()+StoryName).setValue(storyData).addOnSuccessListener {
                    Toast.makeText(this,"Success Saving Story",Toast.LENGTH_SHORT).show()
                }
        }
        view_current_story.setOnClickListener {
            val StoryName = Name_of_Story.text.toString()
            val StoryDesc = Story_Description.text.toString()
            if(StoryName.isEmpty() || StoryDesc.isEmpty()){
                Toast.makeText(this,"Enter a story please",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this,CurrentStoryView::class.java)
            intent.putExtra("StoryName",StoryName)
            intent.putExtra("StoryDesc",StoryDesc)
            startActivity(intent)
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

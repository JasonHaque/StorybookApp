package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import com.example.storybookapp.R
import com.example.storybookapp.Views.HomeView
import com.example.storybookapp.Views.ProfileView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*


class LogInActivity : AppCompatActivity() {
    var userID: String = ""
    val firebaseAuth:FirebaseAuth= FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bind()
        checkUserStatus()
    }
    private fun bind(){

        log_in_mail.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //...
                // Perform your action on key press here
                // ...
                true
            } else false
        })

        log_in_password.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //...
                // Perform your action on key press here
                // ...
                true
            } else false
        })

        goto_sign_up_button.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        log_in_button.setOnClickListener {
            val email=log_in_mail.text.toString()
            val password =log_in_password.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            logIn(email,password)

        }

    }
    private fun checkUserStatus() {
        if (firebaseAuth.currentUser != null) {
            val ID = firebaseAuth.currentUser!!.email!!.toString().split("@".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()
             userID = ID[0]
            startActivity(Intent(this@LogInActivity, OpeningActivity::class.java))
        }
    }
    private fun logIn(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
            val intent=Intent(this, OpeningActivity::class.java)
            startActivity(intent)
            return@addOnSuccessListener
        }.addOnFailureListener{
            Toast.makeText(this, "Failed Logging in $it",Toast.LENGTH_SHORT).show()
            return@addOnFailureListener
        }
        return
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}

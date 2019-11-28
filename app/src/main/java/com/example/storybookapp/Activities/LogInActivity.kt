package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storybookapp.R
import com.example.storybookapp.Views.HomeView
import com.example.storybookapp.Views.ProfileView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {
    val firebaseAuth:FirebaseAuth= FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bind()
    }
    private fun bind(){

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
    private fun logIn(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
            val intent=Intent(this,HomeView::class.java)
            startActivity(intent)
            return@addOnSuccessListener
        }.addOnFailureListener{
            Toast.makeText(this, "Failed Logging in $it",Toast.LENGTH_SHORT).show()
            return@addOnFailureListener
        }
        return
    }
}

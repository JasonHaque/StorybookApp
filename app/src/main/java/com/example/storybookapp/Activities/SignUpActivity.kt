package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import com.example.storybookapp.Classes.UserData
import com.example.storybookapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    val firebaseAuth:FirebaseAuth= FirebaseAuth.getInstance()
    val firedb = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindListenrs()
    }
    private fun bindListenrs(){

        sign_up_mail.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //...
                // Perform your action on key press here
                // ...
                true
            } else false
        })

        sign_up_password.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //...
                // Perform your action on key press here
                // ...
                true
            } else false
        })

        confirm_password.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //...
                // Perform your action on key press here
                // ...
                true
            } else false
        })

        sign_up_name.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                //...
                // Perform your action on key press here
                // ...
                true
            } else false
        })

        sign_up_button.setOnClickListener {
            val email =sign_up_mail.text.toString()
            val password=sign_up_password.text.toString()
            val confirmPass = confirm_password.text.toString()
            val fullname = sign_up_name.text.toString()
            if (email.isEmpty() || password.isEmpty() || confirmPass.isEmpty() || fullname.isEmpty()){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!password.equals(confirmPass)){
                Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            signUp(email,password,fullname)
        }

        backlogin_button.setOnClickListener{
            val intent = Intent(this@SignUpActivity, LogInActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }
    private fun signUp(email:String,password:String,name : String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
            var userdata :UserData = UserData(name,FirebaseAuth.getInstance().currentUser?.uid.toString())
            firedb.child("UserData").child(FirebaseAuth.getInstance().currentUser?.uid.toString()).setValue(userdata)
            return@addOnSuccessListener
        }.addOnFailureListener{
            Toast.makeText(this, "Failed Signing in $it",Toast.LENGTH_SHORT).show()
            return@addOnFailureListener
        }
        return
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@SignUpActivity, LogInActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()

    }
}

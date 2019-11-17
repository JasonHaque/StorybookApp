package com.example.storybookapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storybookapp.R
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindListeners()
    }
    private fun bindListeners(){
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

        }
    }
}

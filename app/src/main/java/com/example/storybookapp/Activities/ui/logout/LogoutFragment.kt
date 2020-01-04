package com.example.storybookapp.Activities.ui.logout

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.storybookapp.Activities.LogInActivity

import com.example.storybookapp.R
import com.google.firebase.auth.FirebaseAuth

class LogoutFragment : Fragment() {

    companion object {
        fun newInstance() =
            LogoutFragment()
    }

    private lateinit var viewModel: LogoutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.logout_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LogoutViewModel::class.java)
        // TODO: Use the ViewModel
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(activity?.applicationContext,"Logging out", Toast.LENGTH_SHORT).show()
        val intent= Intent(activity?.applicationContext, LogInActivity::class.java)
        startActivity(intent)
    }

}

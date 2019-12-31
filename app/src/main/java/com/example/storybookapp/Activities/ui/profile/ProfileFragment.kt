package com.example.storybookapp.Activities.ui.profile

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.storybookapp.Activities.LogInActivity

import com.example.storybookapp.R
import com.example.storybookapp.Views.HomeView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        bindWidgets()
        // TODO: Use the ViewModel
    }

    private fun bindWidgets(){
        profile_view.text= FirebaseAuth.getInstance().currentUser?.email.toString()
        log_out_button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(activity?.applicationContext,"Logging out", Toast.LENGTH_SHORT).show()
            val intent= Intent(activity?.applicationContext, LogInActivity::class.java)
            startActivity(intent)
        }
    }
   /* override fun Fragment.onBackPressed() {
        super.onBackPressed()
        val intent = Intent(activity?.applicationContext, HomeView::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)

    } */

}

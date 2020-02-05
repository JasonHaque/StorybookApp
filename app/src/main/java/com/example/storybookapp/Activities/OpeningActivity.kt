package com.example.storybookapp.Activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.HeaderViewListAdapter
import android.widget.TextView
import com.example.storybookapp.R
import com.google.firebase.auth.FirebaseAuth
import com.squareup.okhttp.internal.framed.Header
import kotlinx.android.synthetic.main.nav_header_opening.*
import kotlinx.android.synthetic.main.profile_fragment.*

class OpeningActivity : AppCompatActivity() {

    var isOpen = false


    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        val fabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        val fabRAnticlockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        val fab1: FloatingActionButton = findViewById(R.id.fab1)
        fab.setOnClickListener {
            if(isOpen) {
                fab1.startAnimation(fabClose)
                fab.startAnimation(fabRClockwise)

                isOpen = false
            }
            else{
                fab1.startAnimation(fabOpen)
                fab.startAnimation(fabRAnticlockwise)

                fab1.isClickable

                isOpen = true
            }
            fab1.setOnClickListener{
                val intent= Intent(this,NewStoryActivity::class.java)
                startActivity(intent)
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val view:View = navView.getHeaderView(0)
        var emailview = view.findViewById<TextView>(R.id.email)
        emailview.text= FirebaseAuth.getInstance().currentUser?.email.toString()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.opening, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}

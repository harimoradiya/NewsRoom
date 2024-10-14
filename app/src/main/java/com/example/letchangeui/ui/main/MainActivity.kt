package com.example.letchangeui.ui.main

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.letchangeui.R
import com.example.letchangeui.databinding.ActivityMainBinding
import com.example.letchangeui.ui.main.frags.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    private val TAG = MainActivity::class.simpleName

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val PERMISSION_REQUEST_CODE = 101



    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setSupportActionBar(binding.mbToolbar)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_video,
                R.id.navigation_web_story,
                R.id.navigation_epaper
            )
        )
        supportActionBar?.setDisplayShowHomeEnabled(false)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Update the title based on the destination
            when (destination.id) {
                R.id.navigation_home -> {
                    supportActionBar?.title = resources.getString(R.string.app_name)
                }
                R.id.navigation_video -> {
                    supportActionBar?.title = "Video"
                }
                R.id.navigation_web_story ->{
                    supportActionBar?.title = "Web Story"
                }
                R.id.navigation_epaper -> {
                    supportActionBar?.title = "E-Paper"
                }
            }
        }


    }







    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchItem: MenuItem = menu.findItem(R.id.search)
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        val searchPlate =   searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        searchPlate.hint = "Search news"
        val searchPlateView: View =
            searchView.findViewById(androidx.appcompat.R.id.search_plate)
        searchPlateView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, "onQueryTextSubmit: $query")
                query?.let {
                    mainActivityViewModel.setQuery(it) // Send query to the ViewModel // Call the method to send the query to the fragment
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d(TAG, "onQueryTextChange: $newText")
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }




    override fun onDestroy() {
        super.onDestroy()
    }



}
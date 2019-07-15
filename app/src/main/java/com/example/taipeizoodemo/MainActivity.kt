package com.example.taipeizoodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity(), OnItemClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFragmentManager.popBackStack()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(position: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailFragment.newInstance(position))
            .addToBackStack(null)
            .commit()
    }
}

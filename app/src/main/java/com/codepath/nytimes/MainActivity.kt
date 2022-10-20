package com.codepath.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.codepath.nytimes.R
import com.codepath.nytimes.ui.books.BestSellerBooksFragment
import com.codepath.nytimes.ui.home.HomeFragment
import com.codepath.nytimes.ui.search.ArticleResultFragment
import com.codepath.nytimes.ui.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
private const val HOME_TAG = "home"
private const val BOOKS_TAG = "books"

private const val SEARCH_TAG = "search"

private const val SETTINGS_TAG = "settings"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager:FragmentManager = supportFragmentManager
        val settingsFragment:Fragment = SettingsFragment.newInstance()
        val homeFragment:Fragment = HomeFragment.newInstance()
        val articleResultFragment:Fragment = ArticleResultFragment.newInstance()
        val bestSellerBooksFragment:Fragment = BestSellerBooksFragment.newInstance()

        var navBar: BottomNavigationView = findViewById(R.id.nav_bar)
        navBar.setOnNavigationItemSelectedListener { item ->
            val ft:FragmentTransaction = supportFragmentManager.beginTransaction()

            when(item.itemId){
                R.id.nav_settings -> {
                    ft.replace(R.id.placeholder_view,settingsFragment, SETTINGS_TAG)
                }
                R.id.nav_search -> {
                    ft.replace(R.id.placeholder_view,articleResultFragment, SEARCH_TAG)
                }
                R.id.nav_home -> {
                    ft.replace(R.id.placeholder_view,homeFragment, HOME_TAG)
                }
                R.id.nav_bestseller -> {
                    ft.replace(R.id.placeholder_view,bestSellerBooksFragment, BOOKS_TAG)
                }
            }
            ft.commit()
            true


        }
        navBar.selectedItemId=R.id.nav_home
    }
}
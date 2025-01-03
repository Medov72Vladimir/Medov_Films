package com.medov.medov_films

import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val materialToolbar: MaterialToolbar = findViewById(R.id.materialToolbar)

        materialToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.nightlight -> {
                    switchTheme()
                    true
                }

                R.id.settings -> {
                    val toast = Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                    toast.show()
                    true
                }

                else -> false
            }
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_bar)
        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    val toast = Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                    toast.show()
                    true
                }

                R.id.watch_later -> {
                    val toast = Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                    toast.show()
                    true
                }

                R.id.collections -> {
                    val toast = Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                    toast.show()
                    true
                }

                else -> false
            }
        }

    }
    fun switchTheme() {
        val nightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (nightMode == Configuration.UI_MODE_NIGHT_NO) {
            // Переключаемся на ночную тему
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            // Переключаемся на дневную тему
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        recreate() // Перезапускаем активность для применения новой темы
    }

}
package com.example.tutmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.example.tutmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        supportActionBar?.title = "Main Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.mOpen -> {
                showToast(1, "Open File")
            }
            R.id.mSave -> {
                showToast(1, "Save File")
            }
            R.id.mSearch -> {
                showToast(2, "Search File", 100, 100)
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    fun showToast(id: Int, text: String, x:Int=0, y:Int=30){
        var toast: Toast
        var image: ImageView

        when (id){
            1 -> {
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            }
            2 -> {
                toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, x , y)
                toast.show()
            }
        }
    }
}
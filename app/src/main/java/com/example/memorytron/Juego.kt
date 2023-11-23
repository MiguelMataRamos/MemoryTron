package com.example.memorytron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memorytron.databinding.ActivityJuegoBinding

class Juego : AppCompatActivity() {
    private lateinit var bind : ActivityJuegoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(bind.root)


    }
}
package com.example.memorytron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.memorytron.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    private var cont = 0
    private var oculto = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.jugar.setOnClickListener {
            var intent = Intent(this,Juego::class.java)
            intent.putExtra("oculto",oculto)
            startActivity(intent)
        }
        bind.jugar2.setOnClickListener {
            var intent = Intent(this,Juego::class.java)
            intent.putExtra("oculto",oculto)
            startActivity(intent)
        }

        bind.card.setOnClickListener {
            cont ++
            if (cont > 5){
                bind.jugar.visibility = View.INVISIBLE
                bind.jugar2.visibility = View.VISIBLE
                bind.t.text = getString(R.string.msj_bienvenidaR)
                bind.t.textSize = 15f
                bind.explicacion.text = getString(R.string.explicacionR)
                bind.explicacion.textSize = 15f
                oculto = true
            }
        }

    }
}
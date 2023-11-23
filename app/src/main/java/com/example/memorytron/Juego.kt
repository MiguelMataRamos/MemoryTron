package com.example.memorytron

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.memorytron.databinding.ActivityJuegoBinding

class Juego : AppCompatActivity() {
    private lateinit var bind : ActivityJuegoBinding
    private var cartas = mutableListOf(
        R.drawable.carta1,R.drawable.carta2,R.drawable.carta3,R.drawable.carta4,R.drawable.carta5,R.drawable.carta6,
        R.drawable.carta1,R.drawable.carta2,R.drawable.carta3,R.drawable.carta4,R.drawable.carta5,R.drawable.carta6
    )
    private var volteada = MutableList(12) { false }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(bind.root)
        cartas.shuffle()

    }


    var pareja = false


    private fun voltear(v:ImageView, p:Int){
        v.setImageResource(cartas[p])
    }

    fun click(view:View){

        when (view.id){
            R.id.c1 -> {

                if (!volteada[0]){

                    volteada[0] = true
                }


            }
            R.id.c2 -> {

            }
            R.id.c3 -> {

            }
            R.id.c4 -> {

            }
            R.id.c5 -> {

            }
            R.id.c6 -> {

            }
            R.id.c7 -> {

            }
            R.id.c8 -> {

            }
            R.id.c9 -> {

            }
            R.id.c10 -> {

            }
            R.id.c11 -> {

            }
            R.id.c12 -> {

            }

        }
    }

}
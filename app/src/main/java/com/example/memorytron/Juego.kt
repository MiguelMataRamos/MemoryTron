package com.example.memorytron

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.example.memorytron.databinding.ActivityJuegoBinding
import kotlinx.coroutines.sync.Semaphore


class Juego : AppCompatActivity() {
    private lateinit var bind: ActivityJuegoBinding
    private var cartas = mutableListOf(
        R.drawable.carta1,
        R.drawable.carta2,
        R.drawable.carta3,
        R.drawable.carta4,
        R.drawable.carta5,
        R.drawable.carta6,
        R.drawable.carta1,
        R.drawable.carta2,
        R.drawable.carta3,
        R.drawable.carta4,
        R.drawable.carta5,
        R.drawable.carta6
    )
    private var volteada = MutableList(12) { false }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(bind.root)
        cartas.shuffle()
        bind.chronometer.start()
        bind.restart.setOnClickListener {
            recreate()
        }
    }


    private var primero = true
    private var vidas = 4
    private var carta1: Drawable? = null
    private var carta2: Drawable? = null
    private var vista1: ImageView? = null
    private var vista2: ImageView? = null
    private var indice1: Int = -1
    private var indice2: Int = -1

    private fun comprobarPareja(d1: Drawable?, d2: Drawable?): Boolean {

        return false
    }

    private fun vidaMenos() {
        when (vidas) {
            4 -> {
                bind.cora4.setImageResource(R.drawable.cora_animacion)

                Handler(Looper.getMainLooper()).postDelayed({
                    bind.cora4.setImageResource(R.drawable.cora_vacio)

                }, 500)

            }

            3 -> {
                bind.cora3.setImageResource(R.drawable.cora_animacion)

                Handler(Looper.getMainLooper()).postDelayed({
                    bind.cora3.setImageResource(R.drawable.cora_vacio)

                }, 500)
            }

            2 -> {
                bind.cora2.setImageResource(R.drawable.cora_animacion)

                Handler(Looper.getMainLooper()).postDelayed({
                    bind.cora2.setImageResource(R.drawable.cora_vacio)

                }, 500)
            }

            1 -> {
                bind.cora1.setImageResource(R.drawable.cora_animacion)

                Handler(Looper.getMainLooper()).postDelayed({
                    bind.cora1.setImageResource(R.drawable.cora_vacio)

                }, 500)
            }
        }

        vidas--

        if (vidas == 0) {
            bind.card.visibility = View.VISIBLE
            bind.restart.visibility = View.VISIBLE
            bind.chronometer.stop()
        }
    }


    private fun mostrar(i: ImageView?, r: Int) {
        i?.setImageResource(cartas[r])
        volteada[r] = true
    }

    private fun ocultar(i: ImageView?, r: Int) {
        i?.setImageResource(R.drawable.trasera)
        volteada[r] = false
    }

    private var semaphore = Semaphore(1)
    fun click(view: View) {
        if (vidas > 0) {
            if (semaphore.tryAcquire()) {
                when (view.id) {
                    R.id.c1 -> {
                        if (!volteada[0]) {

                            if (primero) {
                                vista1 = bind.c1
                                indice1 = 0
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c1
                                indice2 = 0
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)

                                //Si no son iguales hacer esto
                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)


                            }

                        }

                    }

                    R.id.c2 -> {
                        if (!volteada[1]) {

                            if (primero) {
                                vista1 = bind.c2
                                indice1 = 1
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c2
                                indice2 = 1
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)

                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)


                            }

                        }

                    }

                    R.id.c3 -> {
                        if (!volteada[2]) {

                            if (primero) {
                                vista1 = bind.c3
                                indice1 = 2
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c3
                                indice2 = 2
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)


                            }

                        }
                    }

                    R.id.c4 -> {
                        if (!volteada[3]) {

                            if (primero) {
                                vista1 = bind.c4
                                indice1 = 3
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c4
                                indice2 = 3
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)


                            }

                        }
                    }

                    R.id.c5 -> {
                        if (!volteada[4]) {

                            if (primero) {
                                vista1 = bind.c5
                                indice1 = 4
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c5
                                indice2 = 4
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c6 -> {
                        if (!volteada[5]) {

                            if (primero) {
                                vista1 = bind.c6
                                indice1 = 5
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c6
                                indice2 = 5
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c7 -> {
                        if (!volteada[6]) {

                            if (primero) {
                                vista1 = bind.c7
                                indice1 = 6
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c7
                                indice2 = 6
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c8 -> {
                        if (!volteada[7]) {

                            if (primero) {
                                vista1 = bind.c8
                                indice1 = 7
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c8
                                indice2 = 7
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c9 -> {
                        if (!volteada[8]) {

                            if (primero) {
                                vista1 = bind.c9
                                indice1 = 8
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c9
                                indice2 = 8
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c10 -> {
                        if (!volteada[9]) {

                            if (primero) {
                                vista1 = bind.c10
                                indice1 = 9
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c10
                                indice2 = 9
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c11 -> {
                        if (!volteada[10]) {

                            if (primero) {
                                vista1 = bind.c11
                                indice1 = 10
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c11
                                indice2 = 10
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                    R.id.c12 -> {
                        if (!volteada[11]) {

                            if (primero) {
                                vista1 = bind.c12
                                indice1 = 11
                                carta1 = cartas[indice1].toDrawable()
                                mostrar(vista1, indice1)
                                primero = false
                                semaphore.release()

                            } else {
                                vista2 = bind.c12
                                indice2 = 11
                                carta2 = cartas[indice2].toDrawable()
                                mostrar(vista2, indice2)


                                Handler(Looper.getMainLooper()).postDelayed({
                                    ocultar(vista1, indice1)
                                    ocultar(vista2, indice2)
                                    primero = true
                                    vidaMenos()
                                    semaphore.release()
                                }, 1000)

                            }

                        }
                    }

                }
            }
        }

    }
}




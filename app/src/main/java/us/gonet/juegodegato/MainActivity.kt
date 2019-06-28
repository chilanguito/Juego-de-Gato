package us.gonet.juegodegato

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("PrivatePropertyName")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        game = !game



        val valor: String = if (game) {
            "X"
        } else {
            "O"
        }

        when (v) {
            button_1 -> {
                setearButton(button_1, valor, 0)
            }
            button_2 -> {
                setearButton(button_2, valor, 1)
            }
            button_3 -> {
                setearButton(button_3, valor, 2)
            }
            button_4 -> {
                setearButton(button_4, valor, 3)
            }
            button_5 -> {
                setearButton(button_5, valor, 4)
            }
            button_6 -> {
                setearButton(button_6, valor, 5)
            }
            button_7 -> {
                setearButton(button_7, valor, 6)
            }
            button_8 -> {
                setearButton(button_8, valor, 7)
            }
            button_9 -> {
                setearButton(button_9, valor, 8)
            }
        }
        verifyWinner()
        contador++
        verifyEmpat()
    }

    private lateinit var button_1: Button
    private lateinit var button_2: Button
    private lateinit var button_3: Button
    private lateinit var button_4: Button
    private lateinit var button_5: Button
    private lateinit var button_6: Button
    private lateinit var button_7: Button
    private lateinit var button_8: Button
    private lateinit var button_9: Button
    private var game: Boolean = false
    private var lista: Array<Int> = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    private var mapa: MutableMap<Int, Player> = hashMapOf()
    private var contador=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_1 = button_01
        button_2 = button_02
        button_3 = button_03
        button_4 = button_04
        button_5 = button_05
        button_6 = button_06
        button_7 = button_07
        button_8 = button_08
        button_9 = button_09

        button_1.setOnClickListener(this)
        button_2.setOnClickListener(this)
        button_3.setOnClickListener(this)
        button_4.setOnClickListener(this)
        button_5.setOnClickListener(this)
        button_6.setOnClickListener(this)
        button_7.setOnClickListener(this)
        button_8.setOnClickListener(this)
        button_9.setOnClickListener(this)

        for (i in lista) {
            val player = Player(false, "")
            mapa[lista[i]] = player
        }

        reiniciar.setOnClickListener {
            reLoad()
        }
    }

    private fun setearButton(but: Button, valor: String, position: Int) {
        but.text = valor
        but.textSize = 30f
        but.isEnabled = false
        mapa[position]?.turn = valor
        mapa[position]?.presionado = true
    }

    private fun verifyWinner() {

        if (mapa[0]?.presionado == mapa[1]?.presionado == mapa[2]?.presionado && mapa[0]?.turn.equals(mapa[1]?.turn) && mapa[0]?.turn.equals(
                mapa[2]?.turn
            )
        ) {
            winner(mapa[0]?.turn.toString())
        } else if (mapa[3]?.presionado == mapa[4]?.presionado == mapa[5]?.presionado && mapa[3]?.turn.equals(mapa[4]?.turn) && mapa[3]?.turn.equals(
                mapa[5]?.turn
            )
        ) {
            winner(mapa[3]?.turn.toString())
        } else if (mapa[6]?.presionado == mapa[7]?.presionado == mapa[8]?.presionado && mapa[6]?.turn.equals(mapa[7]?.turn) && mapa[6]?.turn.equals(
                mapa[8]?.turn
            )
        ) {
            winner(mapa[6]?.turn.toString())
        } else if (mapa[0]?.presionado == mapa[3]?.presionado == mapa[6]?.presionado && mapa[0]?.turn.equals(mapa[3]?.turn) && mapa[0]?.turn.equals(
                mapa[6]?.turn
            )
        ) {
            winner(mapa[0]?.turn.toString())
        } else if (mapa[1]?.presionado == mapa[4]?.presionado == mapa[7]?.presionado && mapa[1]?.turn.equals(mapa[4]?.turn) && mapa[1]?.turn.equals(
                mapa[7]?.turn
            )
        ) {
            winner(mapa[1]?.turn.toString())
        } else if (mapa[2]?.presionado == mapa[5]?.presionado == mapa[8]?.presionado && mapa[2]?.turn.equals(mapa[5]?.turn) && mapa[2]?.turn.equals(
                mapa[8]?.turn
            )
        ) {
            winner(mapa[2]?.turn.toString())
        } else if (mapa[0]?.presionado == mapa[4]?.presionado == mapa[8]?.presionado && mapa[0]?.turn.equals(mapa[4]?.turn) && mapa[0]?.turn.equals(
                mapa[8]?.turn
            )
        ) {
            winner(mapa[0]?.turn.toString())
        } else if (mapa[6]?.presionado == mapa[4]?.presionado == mapa[2]?.presionado && mapa[6]?.turn.equals(mapa[4]?.turn) && mapa[6]?.turn.equals(
                mapa[2]?.turn
            )
        ) {
            winner(mapa[6]?.turn.toString())
        }

    }

    private fun winner(s: String) {
        Toast.makeText(this, "HAY UN GANADOR, ES EL JUGADOR $s", Toast.LENGTH_LONG).show()
        reLoad()
    }

    fun reLoad() {
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    fun verifyEmpat(){
        if(contador==9){
            Toast.makeText(this, "HUBO UN EMPATE JAJA", Toast.LENGTH_LONG).show()
            reLoad()
        }

    }
}


class Player(var presionado: Boolean, var turn: String)

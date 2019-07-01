package us.gonet.juegodegato

import android.os.Bundle
import android.os.Handler
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
                setButton(button_1, valor, 0)
            }
            button_2 -> {
                setButton(button_2, valor, 1)
            }
            button_3 -> {
                setButton(button_3, valor, 2)
            }
            button_4 -> {
                setButton(button_4, valor, 3)
            }
            button_5 -> {
                setButton(button_5, valor, 4)
            }
            button_6 -> {
                setButton(button_6, valor, 5)
            }
            button_7 -> {
                setButton(button_7, valor, 6)
            }
            button_8 -> {
                setButton(button_8, valor, 7)
            }
            button_9 -> {
                setButton(button_9, valor, 8)
            }
        }
        verifyWinner()
        cont++
        verifyEmp()
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
    private var list: Array<Int> = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    private var map: MutableMap<Int, Player> = hashMapOf()
    private var cont = 0


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

        for (i in list) {
            val player = Player(false, "")
            map[list[i]] = player
        }

        reiniciar.setOnClickListener {
            reLoad()
        }
    }

    private fun setButton(but: Button, valor: String, position: Int) {
        but.text = valor
        but.textSize = 30f
        but.isEnabled = false
        map[position]?.turn = valor
        map[position]?.push = true
    }

    private fun verifyWinner() {

        if (map[0]?.push == map[1]?.push == map[2]?.push && map[0]?.turn.equals(map[1]?.turn) && map[0]?.turn.equals(
                map[2]?.turn
            )
        ) {
            winner(map[0]?.turn.toString())
        } else if (map[3]?.push == map[4]?.push == map[5]?.push && map[3]?.turn.equals(map[4]?.turn) && map[3]?.turn.equals(
                map[5]?.turn
            )
        ) {
            winner(map[3]?.turn.toString())
        } else if (map[6]?.push == map[7]?.push == map[8]?.push && map[6]?.turn.equals(map[7]?.turn) && map[6]?.turn.equals(
                map[8]?.turn
            )
        ) {
            winner(map[6]?.turn.toString())
        } else if (map[0]?.push == map[3]?.push == map[6]?.push && map[0]?.turn.equals(map[3]?.turn) && map[0]?.turn.equals(
                map[6]?.turn
            )
        ) {
            winner(map[0]?.turn.toString())
        } else if (map[1]?.push == map[4]?.push == map[7]?.push && map[1]?.turn.equals(map[4]?.turn) && map[1]?.turn.equals(
                map[7]?.turn
            )
        ) {
            winner(map[1]?.turn.toString())
        } else if (map[2]?.push == map[5]?.push == map[8]?.push && map[2]?.turn.equals(map[5]?.turn) && map[2]?.turn.equals(
                map[8]?.turn
            )
        ) {
            winner(map[2]?.turn.toString())
        } else if (map[0]?.push == map[4]?.push == map[8]?.push && map[0]?.turn.equals(map[4]?.turn) && map[0]?.turn.equals(
                map[8]?.turn
            )
        ) {
            winner(map[0]?.turn.toString())
        } else if (map[6]?.push == map[4]?.push == map[2]?.push && map[6]?.turn.equals(map[4]?.turn) && map[6]?.turn.equals(
                map[2]?.turn
            )
        ) {
            winner(map[6]?.turn.toString())
        }

    }

    private fun winner(s: String) {
        Handler().postDelayed({
            reLoad()
        }, 4000)

        Toast.makeText(this, "HAY UN GANADOR, ES EL JUGADOR $s", Toast.LENGTH_LONG).show()

    }

    private fun reLoad() {
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    private fun verifyEmp() {
        if (cont == 9) {
            Toast.makeText(this, "HUBO UN EMPATE JAJA", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                reLoad()
            }, 4000)
        }
    }
}

class Player(var push: Boolean, var turn: String)

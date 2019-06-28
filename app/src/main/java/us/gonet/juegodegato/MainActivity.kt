package us.gonet.juegodegato

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
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
                button_1.text = valor
                button_1.textSize = 30f
                button_1.isEnabled = false
            }
            button_2 -> {
                button_2.text = valor
                button_2.textSize = 30f
                button_2.isEnabled = false
            }
            button_3 -> {
                button_3.text = valor
                button_3.textSize = 30f
                button_3.isEnabled = false
            }
            button_4 -> {
                button_4.text = valor
                button_4.textSize = 30f
                button_4.isEnabled = false
            }
            button_5 -> {
                button_5.text = valor
                button_5.textSize = 30f
                button_5.isEnabled = false
            }
            button_6 -> {
                button_6.text = valor
                button_6.textSize = 30f
                button_6.isEnabled = false
            }
            button_7 -> {
                button_7.text = valor
                button_7.textSize = 30f
                button_7.isEnabled = false
            }
            button_8 -> {
                button_8.text = valor
                button_8.textSize = 30f
                button_8.isEnabled = false
            }
            button_9 -> {
                button_9.text = valor
                button_9.textSize = 30f
                button_9.isEnabled = false
            }
        }
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

    }
}

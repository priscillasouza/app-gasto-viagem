package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOK()) {

            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
                .show()
        }

    }

    private fun validationOK(): Boolean {
        var validationDistance = false
        var validationPrice = false
        var validationAutonomy = false


        if (editDistance.text.toString() == "") {
            editDistance.error = "Informe a distância"
            validationDistance = false
        } else {
            validationDistance = true
            editDistance.error = null
        }

        if (editPrice.text.toString() == "") {
            editPrice.error = "Informe o preço"
            validationPrice = false
        } else {
            validationPrice = true
            editPrice.error = null
        }

        if (editAutonomy.text.toString() == "") {
            editAutonomy.error = "Informe a autonomia"
            validationAutonomy = false
        } else {
            validationAutonomy = true
            editAutonomy.error = null
        }

        return validationDistance && validationPrice && validationAutonomy
        
    }
}
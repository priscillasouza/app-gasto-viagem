package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(baseContext, "cliquei ${edt_distancia.text.toString()}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
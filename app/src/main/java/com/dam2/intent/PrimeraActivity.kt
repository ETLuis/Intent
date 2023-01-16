package com.dam2.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView

class PrimeraActivity : AppCompatActivity() {

    //Definir el requestCode con una constante

    val dato = 1
    val dato2 = 2
    val dato3 = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1 = findViewById<Button>(R.id.button)

        boton1.setOnClickListener() {

            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("clientes", 2)
            intent.putExtra("proveedores", 1)

            intent.putExtra("numero1", 1)
            intent.putExtra("numero2", 1)
            startActivityForResult(intent, dato)

            intent.putExtra("numero1", 3)
            intent.putExtra("numero2", 2)
            startActivityForResult(intent, dato2)

            intent.putExtra("numero1", 4)
            intent.putExtra("numero2", 7)
            startActivityForResult(intent, dato3)
        }
    }

        //Entra en el onActivityResult cuando se inicia el setResult
        @Deprecated("Deprecated in Java")
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            val resultado1 = findViewById<TextView>(R.id.textView3)
            val resultado2 = findViewById<TextView>(R.id.textView2)
            val resultado3 = findViewById<TextView>(R.id.textView4)
            if (resultCode != Activity.RESULT_OK || data==null) return
            when (requestCode) {
                dato -> {
                    if (data != null) {
                        resultado1.text = data.getStringExtra("resultado")

                        Log.d("Mensaje", "Actualicé el data")
                    }; }

                dato2 -> {
                    if (data != null) {
                        resultado2.text = data.getStringExtra("resultado2")
                        Log.d("Mensaje", "Actualicé el data")
                    }; }

                dato3 -> {
                    if (data != null) {
                        resultado3.text = data.getStringExtra("resultado3")
                        Log.d("Mensaje", "Actualicé el data")
                    }; }

                else -> {}
            }
    }
}

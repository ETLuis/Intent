package com.dam2.intent

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val boton2 = findViewById<Button>(R.id.button2)
        val texto = findViewById<TextView>(R.id.textView)
        val intent = getIntent()

        val value = intent.getIntExtra("proveedores", 0)
        texto.text = value.toString()

        val num1Resultado1 = intent.getIntExtra("numero1", 0)
        val num2Resultado1 = intent.getIntExtra("numero2", 0)

        var resultado = num1Resultado1 + num2Resultado1
        var resultadoString = ""
        resultadoString = resultado.toString()

        intent.putExtra("resultado", resultadoString)
        intent.putExtra("resultado2", resultadoString)
        intent.putExtra("resultado3", resultadoString)
        Log.d("Mensajes", "Actualizado intent")


        //El setResult es para decirle que ya tiene el intent para que lo coja la activity
        setResult(Activity.RESULT_OK, intent)
        Log.d("Mensaje", "Actualizado resultado")
        finish()

    }
}
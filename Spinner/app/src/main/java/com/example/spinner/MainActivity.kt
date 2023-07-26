package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Crear arreglo con los datos: medios de transporte.

        val mediosTransporte = arrayOf("Lunes", "Martes", "Miercoles","Jueves","Viernes","Sabado","Domingo")
        // Crear adaprador para el spinner
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, mediosTransporte)


        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Asocia los datos al spinner
        val spinner: Spinner = findViewById(R.id.spTransporte)
        spinner.adapter=adaptador

        //Asociar los datos al tvHorarios
        val horarioTv: TextView = findViewById(R.id.tvHorarios)

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val medioSelecionado = parent.getItemAtPosition(position).toString()
                val horario = when(medioSelecionado){
                    "Lunes"->"Lunes"
                    "Martes"->"Martes"
                    "Miercoles"->"Miercoles"
                    "Jueves"->"Jueves"
                    "Viernes"->"Viernes"
                    "Sabado"->"Sabado"
                    "Domingo"->"Domingo"
                    else->""
                }
                horarioTv.text="$horario"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                //No hace falta implementar
            }

        }
    }
}
package com.example.tdmpa_2p_pr01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MasaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masa)

        var opcion = ""

        val txtUser = findViewById<TextView>(R.id.txtUsuario2)
        val nombreUsuario = intent.extras?.getString("nombreUsuario").toString()
        txtUser.text = "Bienvenido " + nombreUsuario

        val spnConversion = findViewById<Spinner>(R.id.spnConversion2)
        val masaConversion = resources.getStringArray(R.array.Masa)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, masaConversion)
        spnConversion.adapter = adapter

        spnConversion.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id:Long){
                opcion = masaConversion[position]

                when{
                    opcion == "Onza(oz) a Gramos(g)" ->{
                        validacion()
                        onzaAGramos()
                    }

                    opcion == "Libra(lb) a Kilogramos(kg)" ->{
                        validacion()
                        libraAKilogramos()
                    }

                    opcion == "Ton(T) a Toneladas(Tn)" ->{
                        validacion()
                        tonAToneladas()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MasaActivity, "No se seleccionó nada",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validacion(){
        var txtCantidadMasa = findViewById<EditText>(R.id.txtCantidad2)
        if(txtCantidadMasa.text.isEmpty()){
            txtCantidadMasa.setText("0")
        }
    }

    fun onzaAGramos(){
        var txtCantidadMasa = findViewById<EditText>(R.id.txtCantidad2)
        var txtResultadoMasa = findViewById<TextView>(R.id.txtResultado2)

        var resultado = txtCantidadMasa.text.toString().toDouble() * 28.35
        txtResultadoMasa.text = String.format("%.4f", resultado) + " gramos"
    }

    fun libraAKilogramos(){
        var txtCantidadMasa = findViewById<EditText>(R.id.txtCantidad2)
        var txtResultadoMasa = findViewById<TextView>(R.id.txtResultado2)

        var resultado = txtCantidadMasa.text.toString().toDouble() / 2.205
        txtResultadoMasa.text = String.format("%.4f", resultado) + " kilogramos"
    }

    fun tonAToneladas(){
        var txtCantidadMasa = findViewById<EditText>(R.id.txtCantidad2)
        var txtResultadoMasa = findViewById<TextView>(R.id.txtResultado2)

        var resultado = txtCantidadMasa.text.toString().toDouble() / 1.102
        txtResultadoMasa.text = String.format("%.4f", resultado) + "toneladas"
    }
}
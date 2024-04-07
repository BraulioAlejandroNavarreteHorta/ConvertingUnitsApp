package com.example.tdmpa_2p_pr01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class LongitudActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_longitud)

        var opcion = ""

        val txtUser = findViewById<TextView>(R.id.txtUsuario)
        val nombreUsuario = intent.extras?.getString("nombreUsuario").toString()
        txtUser.text = "Bienvenido " + nombreUsuario

        val spnConversion = findViewById<Spinner>(R.id.spnConversion)
        val longitudConversion = resources.getStringArray(R.array.Longitud)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, longitudConversion)
        spnConversion.adapter = adapter

        spnConversion.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id:Long){
                opcion = longitudConversion[position]

                when{
                    opcion == "Pulgada(In) a Centimetros" ->{
                        validacion()
                        pulgadaACentimetros()
                    }

                    opcion == "Pie(ft) a Metros(m)" ->{
                        validacion()
                        pieAMetros()

                    }

                    opcion == "Milla(mi) a Kilómetros(Km)" ->{
                        validacion()
                        millaAKilometros()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@LongitudActivity, "No se seleccionó nada",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validacion(){
        var txtCantidadLongitud = findViewById<EditText>(R.id.txtCantidad)
        if(txtCantidadLongitud.text.isEmpty()){
            txtCantidadLongitud.setText("0")
        }
    }

    fun pulgadaACentimetros(){
        var txtCantidadLongitud = findViewById<EditText>(R.id.txtCantidad)
        var txtResultadoLongitud = findViewById<TextView>(R.id.txtResultado)

        var resultado = txtCantidadLongitud.text.toString().toDouble() * 2.54
        txtResultadoLongitud.text = String.format("%.4f", resultado) + " centimetros"
    }

    fun pieAMetros(){
        var txtCantidadLongitud = findViewById<EditText>(R.id.txtCantidad)
        var txtResultadoLongitud = findViewById<TextView>(R.id.txtResultado)

        var resultado = txtCantidadLongitud.text.toString().toDouble() / 3.281
        txtResultadoLongitud.text = String.format("%.4f", resultado) + " metros"
    }

    fun millaAKilometros(){
        var txtCantidadLongitud = findViewById<EditText>(R.id.txtCantidad)
        var txtResultadoLongitud = findViewById<TextView>(R.id.txtResultado)

        var resultado = txtCantidadLongitud.text.toString().toDouble() * 1.609
        txtResultadoLongitud.text = String.format("%.4f", resultado) + " kilometros"
    }
}
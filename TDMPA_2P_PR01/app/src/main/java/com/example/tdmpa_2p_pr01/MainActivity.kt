package com.example.tdmpa_2p_pr01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var opcion = ""

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val spnInicio = findViewById<Spinner>(R.id.spInicio)
        val usuario = findViewById<EditText>(R.id.txtNombre)

        val unidades = resources.getStringArray(R.array.Unidades)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, unidades)
        spnInicio.adapter = adapter

        spnInicio.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id:Long){
                opcion = unidades[position]
                Toast.makeText(this@MainActivity, "Has elegido: " + unidades[position],
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "No se seleccionó nada",
                    Toast.LENGTH_SHORT).show()
            }
        }

        btnIniciar.setOnClickListener {
            validacion()
                when{
                    opcion == "Unidades de Masa" ->{
                        val intent = Intent(this, MasaActivity::class.java)
                        intent.putExtra("nombreUsuario", nombreUsuario)
                        startActivity(intent)
                    }

                    opcion == "Unidades de Longitud" ->{
                        val intent = Intent(this, LongitudActivity::class.java)
                        intent.putExtra("nombreUsuario", nombreUsuario)
                        startActivity(intent)
                    }
                }
            }
        }

    var nombreUsuario = ""

        fun validacion(){
            val usuario = findViewById<EditText>(R.id.txtNombre)

            if(usuario.text.toString().isEmpty()){
                nombreUsuario = "Anónimo"
            }
            else{
                nombreUsuario = usuario.text.toString()
            }
        }
    }

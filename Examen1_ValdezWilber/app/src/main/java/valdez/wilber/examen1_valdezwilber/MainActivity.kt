package valdez.wilber.examen1_valdezwilber

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tuNombreEditText: EditText
    private lateinit var crushEditText: EditText
    private lateinit var btnCalcularButton: Button
    private lateinit var tvPorcentaje: TextView
    private lateinit var mensajeBoda: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tuNombreEditText = findViewById(R.id.tuNombre)
        crushEditText = findViewById(R.id.crush)
        btnCalcularButton = findViewById(R.id.btnCalcular)
        tvPorcentaje = findViewById(R.id.tvPorcentaje)
        mensajeBoda =findViewById(R.id.mensaje)


        tvPorcentaje.visibility = View.GONE
        mensajeBoda.visibility = View.GONE

        btnCalcularButton.setOnClickListener {
            calcularCompatibilidad()
        }

    }

        fun calcularCompatibilidad() {
            val tuNombre = tuNombreEditText.text.toString()
            val nombreCrush = crushEditText.text.toString()

            if (tuNombre.isEmpty() || nombreCrush.isEmpty()) {
                Toast.makeText(this, "Escribe los nombreeeesss (porfa)", Toast.LENGTH_SHORT).show()
                tvPorcentaje.visibility = View.GONE
                mensajeBoda.visibility = View.GONE
                return

            }
            val nombreCombinado = (tuNombre + nombreCrush).toLowerCase().replace(" ", "")

            if(nombreCombinado.isEmpty()) {
                Toast.makeText(this, "Nombres invalidos para el calculo", Toast.LENGTH_SHORT).show()
                tvPorcentaje.visibility = View.GONE
                mensajeBoda.visibility = View.GONE
                return
            }

            var countVocales = 0
            val vocales = "aeiou"

            for (char in nombreCombinado) {
                if (vocales.contains(char)) {
                    countVocales++
                }
            }

            val totalLetras = nombreCombinado.length.toFloat()

            val porcentajeBB = if (totalLetras > 0) {
                (countVocales / totalLetras) * 100
           } else {
                0f
            }



         //   val porcentaje: Int = if (totalLetras > 0) {
         //       ((countVocales.toDouble() / totalLetras.toDouble()) * 100).toInt()
         //   } else {
         //       0f
         //   }



            val porcentajeFinal = ((porcentajeBB * 0.90 + 10) % 101).toInt()

           // val porcentajeFinal = if (porcentaje > 100) 100 else porcentaje



            tvPorcentaje.text = "$porcentajeFinal%"
            tvPorcentaje.visibility = View.VISIBLE

            when (porcentajeFinal) {
                in 90..100 -> tvPorcentaje.setTextColor(Color.RED)
                in 75..89 -> tvPorcentaje.setTextColor(Color.parseColor("#ED7CCC"))
                in 60..74 -> tvPorcentaje.setTextColor(Color.parseColor("#F06D41"))
                else -> tvPorcentaje.setTextColor(Color.parseColor("#6479FB"))

            }

            if (porcentajeFinal >= 100) {
                mensajeBoda.visibility = View.VISIBLE
            } else {
                mensajeBoda.visibility = View.GONE
            }



        }



}

// Wilber Valdez Quintero Wilber Valdez Quintero Wiber Valdez Quintero Wilber Valdez Quintero Wilber Valdez Quintero Wilber Valdez Quintero Wilber Valdez Quintero


    //'a' 'A' 'e' 'E' 'i' 'I' 'o' 'O' 'u' 'U'


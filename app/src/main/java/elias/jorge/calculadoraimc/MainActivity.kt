package elias.jorge.calculadoraimc

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Double.parseDouble
import kotlin.math.pow

class MainActivity : AppCompatActivity()
{
    var imc = 0.0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextWeight : EditText = findViewById(R.id.editTextWeight)
        val editTextHeight : EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate : Button = findViewById(R.id.buttonCalculate)
        val textViewIMC : TextView = findViewById(R.id.textViewIMC)
        val textViewRange : TextView = findViewById(R.id.textViewRange)

        buttonCalculate.setOnClickListener{
            if (!TextUtils.isEmpty(editTextWeight.text) || !TextUtils.isEmpty(editTextHeight.text))
            {
                imc = parseDouble(editTextWeight.text.toString()) / (parseDouble(editTextHeight.text.toString())).pow (2)

                if (imc < 18.5)
                {
                    textViewIMC.text = imc.toString()
                    textViewRange.text = "Underweight"
                    textViewRange.setBackgroundResource(R.color.colorGreenish)
                }
                if (imc in 18.5..24.9)
                {
                    textViewIMC.text = imc.toString()
                    textViewRange.text = "Normal Weight"
                    textViewRange.setBackgroundResource(R.color.colorGreen)
                }
                if (imc in 25.5..29.9)
                {
                    textViewIMC.text = imc.toString()
                    textViewRange.text = "Overweight"
                    textViewRange.setBackgroundResource(R.color.colorYellow)
                }
                if (imc in 30.0..34.9)
                {
                    textViewIMC.text = imc.toString()
                    textViewRange.text = "Type 1 Obesity"
                    textViewRange.setBackgroundResource(R.color.colorOrange)
                }
                if (imc in 35.0..39.9)
                {
                    textViewIMC.text = imc.toString()
                    textViewRange.text = "Type 2 Obesity"
                    textViewRange.setBackgroundResource(R.color.colorRed)
                }
                if (imc >= 40)
                {
                    textViewIMC.text = imc.toString()
                    textViewRange.text = "Type 3 Obesity (morbid)"
                    textViewRange.setBackgroundResource(R.color.colorBrown)
                }
            }
        }
    }
}
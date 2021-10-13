package com.masterclass.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masterclass.alcoolougasolina.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalculate.setOnClickListener {
            btCalculate()
        }


    }

    fun btCalculate() {

        //Recupendo valores digitados
        val priceAlcohol = etPriceAlcohol.text.toString()
        val priceGasoline = etPriceGasoline.text.toString()

        val validateField = validateField(priceAlcohol,priceGasoline)
        if (validateField){
            calculateBestPrice(priceAlcohol, priceGasoline)
        }else{
            tvResult.text = "Preencha os preços primerio"
        }


    }

    fun validateField(priceAlcohol: String, priceGasoline: String): Boolean {
        //Validando os campos
        var fieldValidate = true

        if (priceAlcohol == null || priceAlcohol.equals("")){
            fieldValidate = false
        } else if (priceGasoline == null || priceGasoline.equals("")){
            fieldValidate = false
        }

        return fieldValidate

    }

    fun calculateBestPrice(priceAlcohol: String, priceGasoline: String) {

        //Convertendo valores string para numeros
        val valueAlcohol = priceAlcohol.toDouble()
        val valueGasoline = priceGasoline.toDouble()

        /*Faz cálculo (preço Alcool / preço Gasolina)
        Se resultado >= 0.7 melhor utilizar gasolina
        senão melhor utilizar Álcool
         */

        var resultPrice = valueAlcohol / valueGasoline
        if (resultPrice >= 0.7) {
            tvResult.text = "Melhor utilizar Gasolina"
        } else {
            tvResult.text = "Melhor utilizar Álcool"
        }
    }
}



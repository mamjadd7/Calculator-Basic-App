package com.imjad.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.imjad.calculatorapp.databinding.ActivityMainBinding
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var valueOne: Int? = null
    var valueTwo: Int? = null
    var operator by Delegates.notNull<Char>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnZero.setOnClickListener(this)
        binding.btnOne.setOnClickListener(this)
        binding.btnTwo.setOnClickListener(this)
        binding.btnThree.setOnClickListener(this)
        binding.btnFour.setOnClickListener(this)
        binding.btnFive.setOnClickListener(this)
        binding.btnSix.setOnClickListener(this)
        binding.btnSeven.setOnClickListener(this)
        binding.btnEight.setOnClickListener(this)
        binding.btnNine.setOnClickListener(this)
        binding.btnDot.setOnClickListener(this)
        binding.btnDivide.setOnClickListener(this)
        binding.btnMultiply.setOnClickListener(this)
        binding.btnPlus.setOnClickListener(this)
        binding.btnMinus.setOnClickListener(this)
        binding.btnEqual.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val values = binding.textViewValue.text.toString()
        when (v?.id) {
            binding.btnZero.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "0"
                } else {
                    binding.textViewValue.text = values + "0"
                }
            }

            binding.btnOne.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "1"
                } else {
                    binding.textViewValue.text = values + "1"
                }
            }

            binding.btnTwo.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "2"
                } else {
                    binding.textViewValue.text = values + "2"
                }
            }

            binding.btnThree.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "3"
                } else {
                    binding.textViewValue.text = values + "3"
                }
            }

            binding.btnFour.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "4"
                } else {
                    binding.textViewValue.text = values + "4"
                }
            }

            binding.btnFive.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "5"
                }
                else {
                    binding.textViewValue.text = values + "5"
                }
            }

            binding.btnSix.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "6"
                } else {
                    binding.textViewValue.text = values + "6"
                }
            }

            binding.btnSeven.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "7"
                } else {
                    binding.textViewValue.text = values + "7"
                }
            }

            binding.btnEight.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "8"
                } else {
                    binding.textViewValue.text = values + "8"
                }
            }

            binding.btnNine.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "9"
                } else {
                    binding.textViewValue.text = values + "9"
                }
            }

            binding.btnDot.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "0."
                }
                else {
                    if (values == "0." || values.contains(".")) {
                        return
                    }
                    else if (values == "-") {
                        binding.textViewValue.text = values+"0."
                    }
                    else {
                        binding.textViewValue.text = "$values."
                    }

                }
            }

            binding.btnClear.id -> {
                binding.textViewValue.text = "0"
                binding.textViewResult.text = ""
            }

            binding.btnDivide.id -> {
                if (values == "-"){
                    binding.textViewValue.text = "0"
                }
                else if (values.last() == '/'  || values.last() == '+' || values.last() == '-' || values.last() == 'x') {
//                    val removedLast = binding.textViewValue.text.toString().dropLast(1)
                    binding.textViewValue.text = values.dropLast(1) + "/"

                }
                else if( values == "0"|| values.last() == '.'){
                    return
                }

                else {
                    binding.textViewValue.text = "$values/"
                }
            }

            binding.btnMultiply.id -> {
                if (values == "-"){
                    binding.textViewValue.text = "0"
                }
                else if (values.last() == '/'  || values.last() == '+' || values.last() == '-' || values.last() == 'x') {
//                    val removedLast = binding.textViewValue.text.toString().dropLast(1)
                    binding.textViewValue.text = values.dropLast(1) + "x"

                }
                else if( values == "0"|| values.last() == '.'){
                    return
                }
                else {
                    binding.textViewValue.text = values + "x"
                }
            }

            binding.btnPlus.id -> {
                if (values == "-"){
                    binding.textViewValue.text = "0"
                }
                else if (values.last() == '/'  || values.last() == '+' || values.last() == '-' || values.last() == 'x') {

                    binding.textViewValue.text = values.dropLast(1) + "+"

                }
                else if( values == "0"|| values.last() == '.'){
                    return
                }

                else {
                    val value= binding.textViewValue.text.toString()

                    binding.textViewValue.text = "$value+"
                }
            }

            binding.btnMinus.id -> {
                if (values.last() == '/'  || values.last() == '+' || values.last() == '-' || values.last() == 'x') {

                    binding.textViewValue.text = values.dropLast(1) + "-"

                }
                else if(values.last() == '.'){
                    return
                }
                else if(values == "0"){
                    binding.textViewValue.text = "-"
                }
                else {
                    binding.textViewValue.text = "$values-"
                }
            }

            binding.btnEqual.id -> {

            }

        }
    }
    private fun getInputExpression(): String {
        var expression = binding.textViewValue.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

}
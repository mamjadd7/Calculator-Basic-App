package com.imjad.calculatorapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.imjad.calculatorapp.databinding.ActivityMainBinding
import java.util.Stack
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
        binding.btnClearAll.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val values = binding.textViewValue.text.toString()
        when (v?.id) {
            binding.btnZero.id -> {
                if (values == "0") {
                    binding.textViewValue.text = "0"
                }
                else if (values.endsWith("/0")) {
                    return
                }
                else {
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
                } else {
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
                } else {
                    if (values == "0." || values.last() == '.' || values.last() == '*' || values.last() == '/' || values.last() == '+' || values.last() == '-') {
                        return
                    } else if (values == "-") {
                        binding.textViewValue.text = values + "0."
                    } else {
                        binding.textViewValue.text = "$values."
                    }
                }
            }

            binding.btnClearAll.id -> {
                binding.textViewValue.text = "0"
                binding.textViewResult.text = ""
            }

            binding.btnClear.id -> {
                binding.textViewValue.text = values.dropLast(1)
            }

            binding.btnDivide.id -> {
                if (values == "-") {
                    binding.textViewValue.text = "0"
                } else if (values.last() == '/' || values.last() == '+' || values.last() == '-' || values.last() == '*') {
//                    val removedLast = binding.textViewValue.text.toString().dropLast(1)
                    binding.textViewValue.text = values.dropLast(1) + "/"

                } else if (values == "0" || values.last() == '.') {
                    return
                } else {
                    binding.textViewValue.text = "$values/"
                }
            }

            binding.btnMultiply.id -> {
                if (values == "-") {
                    binding.textViewValue.text = "0"
                } else if (values.last() == '/' || values.last() == '+' || values.last() == '-' || values.last() == '*') {
//                    val removedLast = binding.textViewValue.text.toString().dropLast(1)
                    binding.textViewValue.text = values.dropLast(1) + "*"

                } else if (values == "0" || values.last() == '.') {
                    return
                } else {
                    binding.textViewValue.text = "$values*"
                }
            }

            binding.btnPlus.id -> {
                if (values == "-") {
                    binding.textViewValue.text = "0"
                } else if (values.last() == '/' || values.last() == '+' || values.last() == '-' || values.last() == '*') {

                    binding.textViewValue.text = values.dropLast(1) + "+"

                } else if (values == "0" || values.last() == '.') {
                    return
                } else {
                    val value = binding.textViewValue.text.toString()

                    binding.textViewValue.text = "$value+"
                }
            }

            binding.btnMinus.id -> {
                if (values.last() == '/' || values.last() == '+' || values.last() == '-' || values.last() == '*') {

                    binding.textViewValue.text = values.dropLast(1) + "-"

                } else if (values.last() == '.') {
                    return
                } else if (values == "0") {
                    binding.textViewValue.text = "-"
                } else {
                    binding.textViewValue.text = "$values-"
                }
            }

            binding.btnEqual.id -> {
//                val getResult = binding.textViewValue.text.toString()
//                if (getResult.last() == '/' || getResult.last() == '*' || getResult.last() == '+' || getResult.last() == '-') {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Please remove the last sign",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                } else if (getResult.endsWith("/0")) {
//                    Toast.makeText(this@MainActivity, "Can't divide by 0", Toast.LENGTH_SHORT)
//                        .show()
//                } else {
//                    val expression = ExpressionBuilder(getResult).build()
//                    val result = expression.evaluate()
//                    val longResult = result.toLong()
//                    if (result == longResult.toDouble()) {
//                        binding.textViewResult.text = longResult.toString()
//                    } else {
//                        binding.textViewResult.text = result.toString()
//                    }
//                }

                sol(binding.textViewValue)
            }
        }
    }


    fun applyOp(operatorX: Char, a: Float, b: Float): Float {
        when (operatorX) {
            '+' -> return b + a
            '-' -> return b - a
            '*' -> return b * a
            '/' -> {
                if (a != 0F) return b / a
            }
        }
        return 0F
    }
    fun checkP(operatorA: Char, operatorB: Char): Boolean {
        return !(( operatorA == '+' || operatorA == '-') && ( operatorB == '*' || operatorB == '/'))
    }

    fun letsCalculate(mS: String): Float {
        val myChar = mS.toCharArray()
        val myNumStack = Stack<Float>()
        val operatorStack = Stack<Char>()
        var i = 0
        while (i < myChar.size) {
            if ((myChar[i] in '0'..'9') || myChar[i] == '.') {
                val stringBuffer = StringBuilder()
                while (i < myChar.size && (myChar[i] in '0'..'9' || myChar[i] == '.')) {
                    stringBuffer.append(myChar[i++])
                }
                myNumStack.push(stringBuffer.toString().toFloat())
                i--
            }  else if (myChar[i] == '/' || myChar[i] == '*' || myChar[i] == '+' || myChar[i] == '-') {
                while (!operatorStack.empty() && checkP(myChar[i], operatorStack.peek())) {
                    myNumStack.push( applyOp(operatorStack.pop(),myNumStack.pop(),myNumStack.pop()))
                }
                operatorStack.push(myChar[i])
            }
            i++
        }
        while (!operatorStack.empty()) {
            myNumStack.push(applyOp(operatorStack.pop(), myNumStack.pop(), myNumStack.pop()))
        }
        return myNumStack.pop()
    }

    @SuppressLint("SetTextI18n")
    fun sol(x: View?) {
        try {
            binding.textViewResult.setTextColor(Color.BLACK)
            binding.textViewResult.text = "${letsCalculate(binding.textViewValue.text.toString())}"
        } catch (e: Exception) {
            binding.textViewResult.setTextColor(Color.RED)
            binding.textViewResult.text = "Error"
        }
    }
}
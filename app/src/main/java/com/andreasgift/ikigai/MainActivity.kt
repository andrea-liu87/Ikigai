package com.andreasgift.ikigai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreasgift.ikigai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = MultipleViewAdapter(applicationContext, getDummyData())
        layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun getDummyData(): List<Any> {
        return listOf(
            Income(incomeCategory.Salary, "Bank Acc A", 3000),
            Expense(expenseCategory.Groceries, "Credit Card X", 200),
            Expense(expenseCategory.Food, "Cash", 60),
            Expense(expenseCategory.Food, "Credit Card X", 120),
            Income(incomeCategory.Freelance, "PayPal", 500)
        )
    }
}
package com.andreasgift.ikigai

enum class expenseCategory { Groceries, Transportation, Food, Misc }
class Expense(
    val category: expenseCategory,
    val wallet: String,
    val amount: Int
)
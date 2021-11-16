package com.andreasgift.ikigai

enum class incomeCategory { Salary, Freelance, Bonus }
class Income(
    val title: incomeCategory,
    val wallet: String,
    val amount: Int
)
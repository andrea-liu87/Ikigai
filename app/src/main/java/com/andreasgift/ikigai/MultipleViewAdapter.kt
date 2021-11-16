package com.andreasgift.ikigai

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreasgift.ikigai.databinding.LisitemIncomeBinding
import com.andreasgift.ikigai.databinding.ListitemExpenseBinding

class MultipleViewAdapter(val context: Context, val data: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_INCOME = 0
    private val TYPE_EXPENSE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        if (viewType == TYPE_INCOME) {
            val binding = LisitemIncomeBinding.inflate(layoutInflater, parent, false)
            return IncomeViewHolder(binding)
        } else {
            val binding = ListitemExpenseBinding.inflate(layoutInflater, parent, false)
            return ExpenseViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is IncomeViewHolder) {
            val income = data[position] as Income
            holder.binding.tvIncomeTitle.text = income.title.name
            holder.binding.tvWallet.text = income.wallet
            holder.binding.tvIncomeAmount.text = "${income.amount} USD"
        } else {
            holder as ExpenseViewHolder
            val expense = data[position] as Expense
            holder.binding.tvExpenseCategory.text = expense.category.name
            holder.binding.tvWallet.text = expense.wallet
            holder.binding.tvExpenseAmount.text = "${expense.amount} USD"
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (data[position] is Income) {
            return TYPE_INCOME
        } else if (data[position] is Expense) {
            return TYPE_EXPENSE
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        if (data.isEmpty()) return 0
        return data.size
    }

    // create each ViewHolder
    class IncomeViewHolder(val binding: LisitemIncomeBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ExpenseViewHolder(val binding: ListitemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root)
}
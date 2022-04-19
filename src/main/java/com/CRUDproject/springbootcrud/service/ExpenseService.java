package com.CRUDproject.springbootcrud.service;

import com.CRUDproject.springbootcrud.model.Expense;
import com.CRUDproject.springbootcrud.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense By ID %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public void getExpenseByName(){

    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);

    }
}

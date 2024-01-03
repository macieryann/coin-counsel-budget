package com.github.macieryann.coincounselbudget.service;

import com.github.macieryann.coincounselbudget.common.StatusCode;
import com.github.macieryann.coincounselbudget.dao.ExpenseDao;
import com.github.macieryann.coincounselbudget.entity.ExpenseEntity;
import com.github.macieryann.coincounselbudget.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ExpenseService extends CrudService<ExpenseEntity, Long> {
    private final ExpenseDao expenseDao;

    @Autowired
    public ExpenseService(ExpenseDao expenseDao) {
        super(expenseDao);
        this.expenseDao = expenseDao;
    }


    @Override
    public void updateFields(ExpenseEntity requestEntity, ExpenseEntity fetchedEntity) {
        // expense_id, category_id, amount, date, description, payment_method, created_at, updated_at
        fetchedEntity.setExpenseId(requestEntity.getExpenseId());
        fetchedEntity.setCategoryId(requestEntity.getCategoryId());
        fetchedEntity.setAmount(requestEntity.getAmount());
        fetchedEntity.setDate(requestEntity.getDate());
        fetchedEntity.setDescription(requestEntity.getDescription());
        fetchedEntity.setPaymentMethod(requestEntity.getPaymentMethod());
        fetchedEntity.setCreatedAt(requestEntity.getCreatedAt());
        fetchedEntity.setUpdatedAt(requestEntity.getUpdatedAt());
    }

    public List<ExpenseEntity> retrieveAllExpenses() {
        return expenseDao.findAll();
    }

    public ExpenseEntity retrieveExpenseById(int id) {
        return expenseDao.retrieveExpenseById(id);
    }

    public ExpenseEntity saveExpense(ExpenseEntity expense) {
        int maxExpenseId = expenseDao.findMaxCategoryId();

        expense.setExpenseId(maxExpenseId + 1);
        expense.setCreatedAt(Instant.now());
        expense.setUpdatedAt(Instant.now());
        // add other columns ?

        return expenseDao.save(expense);
    }

    public StatusCode editExpense(ExpenseEntity expense) {
        int id = expense.getExpenseId();
        expense.setCategoryId(expense.getCategoryId());
        expense.setAmount(expense.getAmount());
        expense.setDate(expense.getDate());
        expense.setDescription(expense.getDescription());
        expense.setPaymentMethod(expense.getPaymentMethod());
        expense.setUpdatedAt(Instant.now());

        return super.editEntity((long) id, expense);
    }

    public String deleteExpense(int id) {
        expenseDao.deleteById((long) id);
        return "expense deleted";
    }
}

package main.java;
import java.time.LocalDate;
import java.util.*;

public class BillManager {
    private Queue<Transaction> transactions;
    private double totalBudget;
    private LocalDate endPeriodDate;

    public BillManager(double total, LocalDate endPeriodDate) {
        this.transactions = new PriorityQueue<>();
        this.totalBudget = total;
        this.endPeriodDate = endPeriodDate;
    }

    public boolean addTransaction(Transaction transaction) {
        if (this.transactions.contains(transaction)) { return false; }
        this.transactions.add(transaction);
        return true;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public void setEndPeriodDate(LocalDate endPeriodDate) {
        this.endPeriodDate = endPeriodDate;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public List<Transaction> getTransactions() {
        return new LinkedList<>(transactions);
    }

    public LocalDate getEndPeriodDate() {
        return endPeriodDate;
    }

    public int daysRemaining() {
        LocalDate current = java.time.LocalDate.now();
        if (endPeriodDate.isBefore(current)) {
            throw new IllegalArgumentException("The end period day is after today. " +
                    "You need to update the end period day");
        }
        return endPeriodDate.getDayOfYear() - current.getDayOfYear();
    }

    public double totalSpent() {
        double total = 0.0;
        Iterator<Transaction> itr = transactions.iterator();
        while (itr.hasNext()) {
            total += itr.next().getAmount();
        }
        return total;
    }

    public double budgetRemaining() {
        return this.totalBudget - totalSpent();
    }

    public double averageAmountPerDayRemaining() {
        int days = this.daysRemaining();
        return Math.round(budgetRemaining() / days * 100) / 100;
    }
}

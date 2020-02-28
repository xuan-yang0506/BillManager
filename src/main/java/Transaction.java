package main.java;
import java.util.Date;

public class Transaction implements Comparable<Transaction> {
    private double amount;
    private String label;
    private Date date;

    public Transaction(double amount, String label, Date date) {
        this.amount = amount;
        this.label = label;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getLabel() {
        return label;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Transaction o) {
        if (o.amount == this.amount && o.label.equals(this.label) && o.date.equals(this.date)) { return 0; }
        if (this.date.equals(o.date)) {
            if (this.amount == o.amount) { return this.label.compareTo(o.label); }
            return this.amount > o.amount ? 1 : -1;
        } else {
            return this.date.compareTo(o.date);
        }
    }
}

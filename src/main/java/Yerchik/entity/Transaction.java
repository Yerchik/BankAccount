package Yerchik.entity;

import javax.persistence.*;

/**
 * Created by Yerchik on 07.03.2017.
 */
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private double balans;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private TypeOfTransaction type;
    @ManyToOne
    private Account account;

    public Transaction() {
    }

    public Transaction(double amount, String date, double balans,
                       Currency currency, TypeOfTransaction type, Account account) {
        this.amount = amount;
        this.date = date;
        this.balans = balans;
        this.currency = currency;
        this.type = type;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBalans() {
        return balans;
    }

    public void setBalans(double balans) {
        this.balans = balans;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public TypeOfTransaction getType() {
        return type;
    }

    public void setType(TypeOfTransaction type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

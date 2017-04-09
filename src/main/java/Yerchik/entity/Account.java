package Yerchik.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String secondName;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactionList;

    public Account() {
    }

    public Account(String name, String secondName, String login, String password, List<Transaction> transactionList) {
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.transactionList = transactionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

package Yerchik.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */

@Entity
public class TypeOfTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false, unique = true)
    private String type;
    @OneToMany(mappedBy = "type")
    private List<Transaction> transactionList;

    public TypeOfTransaction() {
    }

    public TypeOfTransaction(String type) {
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

}

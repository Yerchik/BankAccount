package Yerchik.dao;

import Yerchik.entity.Account;
import Yerchik.entity.Currency;
import Yerchik.entity.Transaction;

import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */

public interface TransactionDao {
    void add(Transaction transaction);

    Transaction findById(int id);

    List<Transaction> findAll(Account account);

    List<Transaction> findByLoginAndCurrency(Account account, Currency currency);


}

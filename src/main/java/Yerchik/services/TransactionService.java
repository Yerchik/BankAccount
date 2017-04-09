package Yerchik.services;

import Yerchik.entity.Transaction;

import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
public interface TransactionService {
    void addFirst(String login);

    void add(double amount, String date, double balans,
             int idCurrency, int idTypeOfTransaction, String login);

    Transaction findById(int id);

    double balansByCurrency(int idCurrency, String login);

    List<Transaction> findAll(String login);

    List<Transaction> findByCurrency(int idCurrency, String login);

}

package Yerchik.services.implementation;

import Yerchik.dao.TransactionDao;
import Yerchik.entity.Transaction;
import Yerchik.services.AccountService;
import Yerchik.services.CurrencyService;
import Yerchik.services.TransactionService;
import Yerchik.services.TypeOfTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private AccountService accountService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private TypeOfTransactionService typeOfTransactionService;


    public void addFirst(String login) {
        Calendar c = Calendar.getInstance();

        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH) + 1;
        int day = c.get(c.DAY_OF_MONTH);
        String date = day + " " + month + " " + year;
        transactionDao.add(new Transaction(0, date, 0, currencyService.findById(4),
                typeOfTransactionService.findById(3), accountService.findByLogin(login)));
    }

    public void add(double amount, String date, double balans, int idCurrency, int idTypeOfTransaction, String login) {

        transactionDao.add(new Transaction(amount, date, balans, currencyService.findById(idCurrency),
                typeOfTransactionService.findById(idTypeOfTransaction), accountService.findByLogin(login)));
    }

    public Transaction findById(int id) {
        return transactionDao.findById(id);
    }

    public double balansByCurrency(int idCurrency, String login) {
        double balans = 0;
        List<Transaction> transactions = new ArrayList<Transaction>();
        List<Transaction> transactionsAllByLogin = findAll(login);

        for (Transaction transaction : transactionsAllByLogin) {
            if (transaction.getCurrency().getId() == idCurrency) {
                transactions.add(transaction);
            }
        }

        if (transactions.size() > 0)
            balans = transactions.get(transactions.size() - 1).getBalans();

        return balans;
    }

    public List<Transaction> findAll(String login) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        List<Transaction> transactionsAll = transactionDao.findAll();

        for (Transaction transaction : transactionsAll) {
            if (transaction.getAccount().getLogin().equals(login)) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public List<Transaction> findByCurrency(int idCurrency, String login) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        List<Transaction> transactionsAllByLogin = findAll(login);

        for (Transaction transaction : transactionsAllByLogin) {
            if (transaction.getCurrency().getId() == idCurrency) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

//    public Transaction tranzactionNoMoney(int idCurrency, String login) {
//        List<Transaction> transactions = new ArrayList<Transaction>();
//        List<Transaction> transactionsAllByLogin = findAll(login);
//
//        for (Transaction transaction : transactionsAllByLogin) {
//            if (transaction.getCurrency().getId() == idCurrency) {
//                transactions.add(transaction);
//            }
//        }
//
//        if (transactions.size() > 0)
//            return transactions.get(transactions.size() - 1);
//         else return transactionsAllByLogin.get(0);
//    }


}

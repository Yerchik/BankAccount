package Yerchik.services.implementation;

import Yerchik.dao.AccountDao;
import Yerchik.dao.CurrencyDao;
import Yerchik.dao.TransactionDao;
import Yerchik.dao.TypeOfTransactionDao;
import Yerchik.entity.Transaction;
import Yerchik.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AccountDao accountDao;
    @Autowired
    private CurrencyDao currencyDao;
    @Autowired
    private TypeOfTransactionDao typeOfTransactionDao;


    public void addFirst(String login) {
        Calendar c = Calendar.getInstance();

        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH) + 1;
        int day = c.get(c.DAY_OF_MONTH);
        String date = day + " " + month + " " + year;
        transactionDao.add(new Transaction(0, date, 0, currencyDao.findById(4),
                typeOfTransactionDao.findById(3), accountDao.findByLogin(login)));
    }

    public void add(double amount, String date, double balans, int idCurrency, int idTypeOfTransaction, String login) {
        transactionDao.add(new Transaction(amount, date, balans, currencyDao.findById(idCurrency),
                typeOfTransactionDao.findById(idTypeOfTransaction), accountDao.findByLogin(login)));
    }

    public Transaction findById(int id) {
        return transactionDao.findById(id);
    }

    public double balansByCurrency(int idCurrency, String login) {
        double balans = 0;
        List<Transaction> transactions = transactionDao.findByLoginAndCurrency(accountDao.findByLogin(login), currencyDao.findById(idCurrency));

        if (transactions.size() > 0)
            balans = transactions.get(transactions.size() - 1).getBalans();

        return balans;
    }

    public List<Transaction> findAll(String login) {

        return transactionDao.findAll(accountDao.findByLogin(login));
    }

    public List<Transaction> findByCurrency(int idCurrency, String login) {

        return transactionDao.findByLoginAndCurrency(accountDao.findByLogin(login), currencyDao.findById(idCurrency));
    }




}

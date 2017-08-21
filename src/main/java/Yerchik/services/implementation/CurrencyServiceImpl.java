package Yerchik.services.implementation;

import Yerchik.dao.CurrencyDao;
import Yerchik.entity.Currency;
import Yerchik.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    public void addList() {
        try {
            List<Currency> currencies = new ArrayList<Currency>();
            currencies.add(new Currency("USD","$"));
            currencies.add(new Currency("UAH","₴"));
            currencies.add(new Currency("EUR","€"));
            currencies.add(new Currency("",""));
            currencyDao.addList(currencies);

        }catch (Exception e){}
    }

    public Currency findById(int id) {
        return currencyDao.findById(id);
    }

    public List<Currency> findAll() {
        List<Currency> currencyList = currencyDao.findAll();
        currencyList.remove(currencyDao.findAll().size() - 1);
        return currencyList;
    }
}

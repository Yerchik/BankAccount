package Yerchik.services.implementation;

import Yerchik.dao.CurrencyDao;
import Yerchik.entity.Currency;
import Yerchik.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    public Currency findById(int id) {
        return currencyDao.findById(id);
    }

    public List<Currency> findAll() {
        List<Currency> currencyList = currencyDao.findAll();
        currencyList.remove(currencyDao.findAll().size() - 1);
        return currencyList;
    }
}

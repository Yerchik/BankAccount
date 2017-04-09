package Yerchik.services;

import Yerchik.entity.Currency;

import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */
public interface CurrencyService {
    Currency findById(int id);
    List<Currency> findAll();
}

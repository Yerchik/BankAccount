package Yerchik.dao;

import Yerchik.entity.Currency;

import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
public interface CurrencyDao {
    Currency findById(int id);
    List<Currency> findAll();


}

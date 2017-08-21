package Yerchik.services;

import Yerchik.entity.TypeOfTransaction;

/**
 * Created by Yerchik on 08.03.2017.
 */
public interface TypeOfTransactionService {
    void addList();
    TypeOfTransaction findById(int id);
}

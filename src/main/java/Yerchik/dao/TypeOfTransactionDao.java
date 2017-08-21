package Yerchik.dao;

import Yerchik.entity.TypeOfTransaction;

import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
public interface TypeOfTransactionDao {
    TypeOfTransaction findById(int id);
    void addList(List<TypeOfTransaction> transactions);


}

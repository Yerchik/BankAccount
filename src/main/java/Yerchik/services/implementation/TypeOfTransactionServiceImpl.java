package Yerchik.services.implementation;

import Yerchik.dao.TypeOfTransactionDao;
import Yerchik.entity.TypeOfTransaction;
import Yerchik.services.TypeOfTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */
@Service
public class TypeOfTransactionServiceImpl implements TypeOfTransactionService {

    @Autowired
    private TypeOfTransactionDao typeOfTransactionDao;

    public void addList() {
        try {
            List<TypeOfTransaction> transactions = new ArrayList<TypeOfTransaction>();
            transactions.add(new TypeOfTransaction("ADD"));
            transactions.add(new TypeOfTransaction("WITHDRAW"));
            transactions.add(new TypeOfTransaction("CREATE ACCOUNT"));
            typeOfTransactionDao.addList(transactions);

        }catch (Exception e){}
    }

    public TypeOfTransaction findById(int id) {
        return typeOfTransactionDao.findById(id);
    }
}

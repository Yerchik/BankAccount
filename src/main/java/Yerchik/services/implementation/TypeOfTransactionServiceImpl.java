package Yerchik.services.implementation;

import Yerchik.dao.TypeOfTransactionDao;
import Yerchik.entity.TypeOfTransaction;
import Yerchik.services.TypeOfTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yerchik on 08.03.2017.
 */
@Service
public class TypeOfTransactionServiceImpl implements TypeOfTransactionService {

    @Autowired
    private TypeOfTransactionDao typeOfTransactionDao;

    public TypeOfTransaction findById(int id) {
        return typeOfTransactionDao.findById(id);
    }
}

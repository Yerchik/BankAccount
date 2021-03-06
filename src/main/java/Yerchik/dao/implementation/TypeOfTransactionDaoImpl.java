package Yerchik.dao.implementation;

import Yerchik.dao.TypeOfTransactionDao;
import Yerchik.entity.TypeOfTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
@Repository
public class TypeOfTransactionDaoImpl implements TypeOfTransactionDao {

    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public TypeOfTransaction findById(int id) {
        return entityManager.find(TypeOfTransaction.class, id);
    }

    @Transactional
    public void addList(List<TypeOfTransaction> transactions) {
        for (TypeOfTransaction transaction : transactions) {
            entityManager.persist(transaction);
        }
    }


}

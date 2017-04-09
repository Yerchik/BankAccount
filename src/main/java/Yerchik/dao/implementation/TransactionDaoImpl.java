package Yerchik.dao.implementation;

import Yerchik.dao.TransactionDao;
import Yerchik.entity.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
@Repository
public class TransactionDaoImpl implements TransactionDao {

    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Transactional
    public Transaction findById(int id) {
        return entityManager.find(Transaction.class, id);
    }

    @Transactional
    public List<Transaction> findAll() {
        return entityManager.createQuery("SELECT c FROM Transaction c").getResultList();
    }

}

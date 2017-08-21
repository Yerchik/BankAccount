package Yerchik.dao.implementation;

import Yerchik.dao.CurrencyDao;
import Yerchik.entity.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yerchik on 07.03.2017.
 */
@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void addList(List<Currency> currencys) {
        for (Currency currency : currencys) {
            entityManager.persist(currency);
        }
    }

    @Transactional
    public Currency findById(int id) {
        return entityManager.find(Currency.class, id);
    }

    @Transactional
    public List<Currency> findAll() {
        return entityManager.createQuery("select c from Currency c").getResultList();
    }
}

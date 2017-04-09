package Yerchik.dao.implementation;

import Yerchik.dao.AccountDao;
import Yerchik.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Yerchik on 07.03.2017.
 */
@Repository
public class AccountDaoImpl implements AccountDao{

    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Account account) {

        entityManager.persist(account);
    }
    @Transactional
    public void edit(Account account) {
        entityManager.merge(account);
    }

    @Transactional
    public void delete(Account account) {
        entityManager.remove(account);
    }

    @Transactional
    public Account findById(int id) {
        return entityManager.find(Account.class, id);
    }

    @Transactional
    public Account findByLogin(String login) {
        return (Account) entityManager.createQuery("select c FROM Account c where c.login = :login")
                .setParameter("login", login).getSingleResult();
    }
}

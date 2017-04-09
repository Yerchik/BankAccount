package Yerchik.dao;

import Yerchik.entity.Account;

/**
 * Created by Yerchik on 07.03.2017.
 */
public interface AccountDao {
    void add(Account account);

    void edit(Account account);

    void delete(Account account);

    Account findById(int id);

    Account findByLogin(String login);

}

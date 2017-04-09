package Yerchik.services;

import Yerchik.entity.Account;

/**
 * Created by Yerchik on 07.03.2017.
 */
public interface AccountService {
    void add(String name, String secondName, String login, String password);

    void edit(int id, String name, String secondName, String login, String password);

    void delete(int id);

    Account findById(int id);

    Account findByLogin(String login);
}

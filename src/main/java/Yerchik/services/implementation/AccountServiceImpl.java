package Yerchik.services.implementation;

import Yerchik.dao.AccountDao;
import Yerchik.entity.Account;
import Yerchik.entity.Transaction;
import Yerchik.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */
@Service("userDetailsService")
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountDao accountDao;

    public void add(String name, String secondName, String login, String password) {
        accountDao.add(new Account(name,secondName, login, password, new ArrayList<Transaction>()));

    }

    public void edit(int id, String name, String secondName, String login, String password) {

    }

    public void delete(int id) {
        accountDao.delete(accountDao.findById(id));

    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public Account findByLogin(String login) {
        return accountDao.findByLogin(login);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

       Account account = accountDao.findByLogin(login);
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(account.getLogin(), account.getPassword(), authorities);
    }


}

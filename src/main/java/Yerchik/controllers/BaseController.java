package Yerchik.controllers;

import Yerchik.entity.Account;
import Yerchik.entity.Currency;
import Yerchik.entity.Transaction;
import Yerchik.services.AccountService;
import Yerchik.services.CurrencyService;
import Yerchik.services.TransactionService;
import Yerchik.services.TypeOfTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yerchik on 08.03.2017.
 */
@Controller
public class BaseController {

    int idCurrencyNoMoney;
    String balans;
    List<Transaction> transactionHistory = new ArrayList<Transaction>();
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private TypeOfTransactionService typeOfTransaction;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, Principal principal) {

        Account account = accountService.findByLogin(principal.getName());
        model.addAttribute("account", account);
        currencyService.addList();
        typeOfTransaction.addList();
        return "home";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginpage() {
        return "login";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam("name") String name,
                               @RequestParam("secondName") String secondName,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password) {
        accountService.add(name, secondName, login, password);
        transactionService.addFirst(login);
        return "redirect:/";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        List<Currency> currencies = currencyService.findAll();
        model.addAttribute("currencies", currencies);
        return "add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("amount") Double amount,
                      @RequestParam("currency") int idCurrency, Principal principal) {
        Calendar c = Calendar.getInstance();

        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH) + 1;
        int day = c.get(c.DAY_OF_MONTH);
        String date = day + " " + month + " " + year;

        transactionService.add(amount, date, transactionService.balansByCurrency(idCurrency, principal.getName()) + amount
                , idCurrency, 1, principal.getName());
        return "redirect:/";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
        List<Currency> currencies = currencyService.findAll();
        model.addAttribute("currencies", currencies);
        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdraw(@RequestParam("amount") Double amount,
                           @RequestParam("currency") int idCurrency, Principal principal) {
        Calendar c = Calendar.getInstance();

        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH) + 1;
        int day = c.get(c.DAY_OF_MONTH);
        String date = day + " " + month + " " + year;

        if (amount > transactionService.balansByCurrency(idCurrency, principal.getName())) {
            idCurrencyNoMoney = currencyService.findById(idCurrency).getId();
            balans = "" + transactionService.balansByCurrency(idCurrency, principal.getName());
            return "redirect:/noMoney";
        } else {
            transactionService.add(amount, date,
                    transactionService.balansByCurrency(idCurrency, principal.getName()) - amount
                    , idCurrency, 2, principal.getName());
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/noMoney", method = RequestMethod.GET)
    public String noMoney(Model model) {
        Currency currency = currencyService.findById(idCurrencyNoMoney);
        model.addAttribute("currency", currency);
        model.addAttribute("balans", balans);
        balans = "";
        return "noMoney";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(Model model, Principal principal) {
        List<Transaction> transactions = transactionService.findAll(principal.getName());
        model.addAttribute("transactions", transactions);
        List<Currency> currencies = currencyService.findAll();
        model.addAttribute("currencies", currencies);
        return "history";
    }

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public String historyForCurrency(@RequestParam("currency") int idCurrency, Principal principal) {
        List<Transaction> transactions = transactionService.findByCurrency(idCurrency, principal.getName());
        transactionHistory = transactions;
        return "redirect:/history2";
    }

    @RequestMapping(value = "/history2", method = RequestMethod.GET)
    public String history2(Model model) {
        List<Transaction> transactions = transactionHistory;
        model.addAttribute("transactions", transactions);
        return "history2";
    }

    @RequestMapping(value = "/showBalans", method = RequestMethod.GET)
    public String shovBalans(Model model) {
        List<Currency> currencies = currencyService.findAll();
        model.addAttribute("currencies", currencies);
        model.addAttribute("balans", balans);
        balans = "";
        return "showBalans";
    }

    @RequestMapping(value = "/balans/{id}", method = RequestMethod.GET)
    public String commodityPage(@PathVariable Integer id, Principal principal) {

        balans = "" + transactionService.balansByCurrency(id, principal.getName()) + " " + currencyService.findById(id).getMarking();
        return "redirect:/showBalans";
    }

}

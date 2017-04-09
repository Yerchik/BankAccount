package Yerchik.app;

import Yerchik.entity.Currency;
import Yerchik.entity.TypeOfTransaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Yerchik on 10.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Main");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Currency currency1 = new Currency("USD","$");
        Currency currency2 = new Currency("UAH","₴");
        Currency currency3 = new Currency("EUR","€");
        Currency currency4 = new Currency("","");

        TypeOfTransaction typeOfTransaction1 = new TypeOfTransaction("ADD");
        TypeOfTransaction typeOfTransaction2 = new TypeOfTransaction("WITHDRAW");
        TypeOfTransaction typeOfTransaction3 = new TypeOfTransaction("CREATE ACCOUNT");

        entityManager.getTransaction().begin();
        entityManager.persist(currency1);
        entityManager.persist(currency2);
        entityManager.persist(currency3);
        entityManager.persist(currency4);

        entityManager.persist(typeOfTransaction1);
        entityManager.persist(typeOfTransaction2);
        entityManager.persist(typeOfTransaction3);


        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

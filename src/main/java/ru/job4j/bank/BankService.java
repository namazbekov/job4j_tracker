package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского перевода денег с одного расчетного счета на другоой
 * @author Дастан
 * @version 1.0
 */

public class BankService {
    /**
     * хранение пользователей осуществляется в карте Map с типом User и List с типом Account
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет пользователя в систему, через метод put
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Этот метод принимает два параметра пользователя и счета
     * , ищет этого пользователя по реализовванному в другом методде поиску и ищет совпадения с счетами
     * , если нет идет процесс добавления пользователя
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }

        }
    }

    /**
     * метод ищет пользователя по имени, ищет в списке users с помшью foreach
     * @param passport
     * @return  если есть совпадения возвращает имя пользователя, в противном случае возварщает null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод ищет пользователя с помощью двух параметров имени и реквизитов
     * , сначала идет поиск по имени  и если пользователь есть
     * , получаем весь список для поиска по реквизитам
     *
     * @param passport
     * @param requisite
     * @return еслие есть сходство получаем список расчетных счетов пользователя
     *      * в противном случае возвращаем null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод отправки денег с расчетного счета на другой счет осуществляется по двум пользователям
     * ,которых мы должны нати в списке с помошью принятых пяти параметров имен и реквизитов и amount.
     * после идет проверка этих пользователей на нераность null и положительного баланса на счету
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return если будет истина , то идет процесс уменьшения баланса одного пользователя и увеличение другого.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
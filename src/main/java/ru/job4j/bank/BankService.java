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
     * , и если есть совпадения возвращает имя пользователя, в противном случае возварщает null
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)) {
                return us;
            }
        }
        return null;
    }

    /**
     * метод ищет пользователя с помощью двух параметров имени и реквизитов
     * , сначала идет поиск по имени  и если пользователь есть
     * , получаем весь список для поиска по реквизитам
     * , еслие есть сходство получаем список расчетных счетов пользователя
     * в противном случае возвращаем null
     *
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account listFind : list) {
                if (listFind.getRequisite().equals(requisite)) {
                    return listFind;
                }
            }
        }

        return null;
    }

    /**
     * метод отправки денег с расчетного счета на другой счет осуществляется по двум пользователям
     * ,которых мы должны нати в списке с помошью принятых пяти параметров имен и реквизитов и amount.
     * после идет проверка этих пользователей на нераность null и положительного баланса на счету
     * и если будет истина , то идет процесс уменьшения баланса одного пользователя и увеличение другого.
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return
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
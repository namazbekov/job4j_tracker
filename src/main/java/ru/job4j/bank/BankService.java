package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();

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
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
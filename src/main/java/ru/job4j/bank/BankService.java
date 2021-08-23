package ru.job4j.bank;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user,new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (users.containsKey(account)) {
                List<Account> list = users.get(user);
                if (!list.contains(account)) {
                    list.add(account);
                }
            }
        }
    }

    public User findByPassport(String passport) {
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)){
                return us;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account user1 = findByRequisite(srcPassport, srcRequisite);
        Account user2 = findByRequisite(destPassport, destRequisite);
        if (user1 != null) {
            if (user2 != null) {
                if (user1.getBalance() > amount) {
                }
            }
        }
        return rsl;
    }
}
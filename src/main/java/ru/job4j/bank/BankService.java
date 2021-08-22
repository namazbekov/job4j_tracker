package ru.job4j.bank;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user.getPassport())) {
            users.put(user.getPassport(), new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        findByPassport(passport);
        for (User us : users.keySet()) {
            if (users.containsKey(account)) {
                users.put(account.getRequisite(), new ArrayList<Account>());
            }
        }
    }

    public User findByPassport(String passport) {
        String key = "";
        for (User us : users.keySet()) {
            if (users.get(us).equals(passport)){
                key = passport;
                break;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        findByPassport(passport);
        for (User user : users.keySet(passport)) {
            if (users.containsKey(requisite)) {
                passport.get
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}
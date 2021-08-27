package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User us : users)  {
            if (us.getUsername().equals(login)) {
                return us;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = user.isValid() && user.getUsername().length() > 3;
        if (!rsl) {
            throw new UserInvalidException("неверный логин ");
        }
        return rsl;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}

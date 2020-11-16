package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User matchLogin = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                matchLogin = user;
            }
        }
        if (matchLogin == null) {
            throw new UserNotFoundException("Совпадений в массиве не обнаружено.");
        }
        return matchLogin;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный.");
        } else if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя меньше трех символов.");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
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
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

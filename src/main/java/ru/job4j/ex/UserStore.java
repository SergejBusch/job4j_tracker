package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rsl = -1;
        for (User user : users) {
            rsl++;
            if (user.getUsername().equals(login)) {
                return users[rsl];
            }
        }
        throw new UserNotFoundException("user not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("user not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
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
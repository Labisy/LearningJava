package org.task2;

import org.task2.user.Sex;
import org.task2.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Users {

    /**
     * В этом классе приватный конструктор, поэтому вызов любого метода осуществляется без "new".
     * List<User> allUsers = Users.getAllUser();
     */
    private Users() {
    }

    /**
     * @return - этот метод который должен вернуть всех пользователей.
     */
    public static List<User> getAllUsers() {
        return new ArrayList<>(User.getAllUsers().values());
    }

    /**
     * @param sex - пол, по которому необходимо вернуть пользователей.
     * @return - этот метод который должен вернуть всех пользователей с полом sex.
     */
    public static List<User> getAllUsers(Sex sex) {
        return User.getAllUsers().values().stream()
                .filter(user -> user.getSex() == sex)
                .toList();
    }

    /**
     * @return - возвращает количество пользователей.
     */
    public static int getHowManyUsers() {
        return getAllUsers().size();
    }

    /**
     * @param sex - пол, по которому необходимо вернуть пользователей.
     * @return - этот метод который должен вернуть всех пользователей с полом sex.
     */
    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    public static void main(String[] args) {
        User user = new User("", 2, Sex.MALE);
        User user2 = new User("ff", 2, Sex.MALE);
        System.out.println(getAllAgeUsers(Sex.FEMALE));
    }

    /**
     * @return - возвращает сумму всех лет пользователей.
     */
    public static int getAllAgeUsers() {
        return (int) getAllUsers().stream()
                .mapToInt(User::getAge)
                .count();
    }

    /**
     * @param sex - пол, у которых необходимо сложить возраст.
     * @return - возвращает сумму всех лет пользователей.
     */
    public static int getAllAgeUsers(Sex sex) {
        return (int) getAllUsers(sex).stream()
                .mapToInt(User::getAge)
                .count();
    }

    /**
     * @return - возвращает средний возраст среди всех пользователей.
     */
    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    /**
     * @param sex - пол, у которых необходимо брать возраст.
     * @return - - возвращает средний возраст среди пользователей с полом sex.
     */
    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }
}

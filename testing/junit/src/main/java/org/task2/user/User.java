package org.task2.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private int age;
    private Sex sex;
    private static Map<Integer, User> allUsers;
    private static int countId = 0;

    public User(String name, int age, Sex sex) {
        if (allUsers == null) {
            allUsers = new HashMap<>();
        }

        this.name = name;
        this.age = age;
        this.sex = sex;

        if (!hasUser()) {
            this.id = ++countId;
            allUsers.put(id, this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public static Map<Integer, User> getAllUsers() {
        return allUsers;
    }

    public static int getCountId() {
        return countId;
    }

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals(this) && user.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}

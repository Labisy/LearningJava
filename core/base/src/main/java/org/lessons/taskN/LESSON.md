# Конструктор

В java конструктор представляет собой, набор параметров, который вы будете передавать при создании нового объекта.\

Рассмотрим пример:

Цель: Создать класс с несколькими конструкторами и продемонстрировать их использование.

Шаги:
1. Создайте новый Java-класс, например `Person`.
2. Определите в классе несколько конструкторов, которые будут принимать различное количество параметров.
3. Воспользуйтесь конструкторами для создания объектов и продемонстрируйте их использование.

Код:
```java
// Создайте новый Java-класс Person
public class Person {
    // Объявление переменных
    private String name;
    private int age;

    // Конструктор без параметров
    public Person() {
        this.name = "Не указано";
        this.age = 0;
    }

    // Конструктор с параметрами name и age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Конструктор с параметрами name и age, использующий конструктор без параметров
    public Person(String name) {
        this(name, 0);
    }

    // Геттеры и сеттеры для name и age
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

    // Метод для вывода информации о человеке
    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

// В main-методе продемонстрируйте использование конструкторов
public class Main {
    public static void main(String[] args) {
        // Создайте объект с помощью конструктора с параметрами
        Person person1 = new Person("Алиса", 30);
        person1.displayInfo();

        // Создайте объект с помощью конструктора с двумя параметрами
        Person person2 = new Person("Боб", 25);
        person2.displayInfo();

        // Создайте объект с помощью конструктора с одним параметром
        Person person3 = new Person("Чарли");
        person3.displayInfo();

        // Создайте объект с помощью конструктора без параметров
        Person person4 = new Person();
        person4.displayInfo();
    }
}
```

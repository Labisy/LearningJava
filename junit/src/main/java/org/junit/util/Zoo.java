package org.junit.util;


import org.junit.enity.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo() {
        init();
    }

    /**
     * Заполнение животных изначальными переменными
     */
    private void init() {
        animals = new ArrayList<>(
                List.of(
                        new Animal("Жираф", 2),
                        new Animal("Обезьяна", 11),
                        new Animal("Бегемот", 5),
                        new Animal("Лев", 1),
                        new Animal("Тигр", 7)
                )
        );
    }

    /**
     * Добавление нового животного
     * @param value - животное, которое необходимо добавить
     */
    public void addAnimal(final Animal value) {
        if (!isInList(value)) animals.add(value);
        else throw new IllegalArgumentException(String.format("Такое животное: '%s' уже существует", value));
    }

    /**
     * Удаление животного
     * @param value - животное, которое необходимо удалить
     */
    public void removeAnimal(final Animal value) {
        if (isInList(value)) animals.remove(value);
        else throw new IllegalArgumentException(String.format("Такого животного: '%s' не существует", value));
    }

    /**
     * Получить животное по названию
     * @param name - название животного
     * @return - Искомое животное
     */
    public Animal getAnimalWithName(final String name) {
        return animals.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Поиск самого старого животного
     * @return - вернуть самое старое животное, первое, какое попадется
     */
    public Animal oldestAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Поиск животное с самым длинным именем
     * @return - возвращаем животное с самым длинным именем
     */
    public Animal longestNameAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(o -> o.getName().length()))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Сортировка по возрасту
     * @return - отсортированный список по возрастанию возраста
     */
    public List<Animal> sortAnimalByAge() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getAge))
                .toList();
    }

    /**
     * Сортировка по имени
     * @return - отсортированный список по алфавиту
     */
    public List<Animal> sortAnimalByName() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .toList();
    }

    /**
     * Проверка существует ли животное в списке
     * @param value - Животное, которое необходимо проверить
     * @return - возвращается true/false в соответствии с существованием
     */
    private boolean isInList(final Animal value) {
        return animals.stream()
                .anyMatch(value::equals);
    }
}

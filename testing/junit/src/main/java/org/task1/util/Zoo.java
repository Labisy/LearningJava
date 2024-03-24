package org.task1.util;


import org.task1.enity.Animal;
import org.task1.types.AnimalType;

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
                        new Animal("Толик", 2, AnimalType.GIRAFFE),
                        new Animal("Митя", 6, AnimalType.GIRAFFE),
                        new Animal("Молли", 11, AnimalType.MONKEY),
                        new Animal("Бил", 5, AnimalType.HIPPOPOTAMUS),
                        new Animal("Соул", 4, AnimalType.HIPPOPOTAMUS),
                        new Animal("Лео", 1, AnimalType.LION),
                        new Animal("Мартин", 3, AnimalType.LION),
                        new Animal("Лиза", 5, AnimalType.LION),
                        new Animal("Тим", 7, AnimalType.TIGER)
                )
        );
    }

    /**
     * Добавление нового животного
     *
     * @param value - животное, которое необходимо добавить
     */
    public void addAnimal(final Animal value) {
        if (!isInList(value)) animals.add(value);
        else throw new IllegalArgumentException(String.format("Такое животное: '%s' уже существует", value));
    }

    /**
     * Удаление животного
     *
     * @param value - животное, которое необходимо удалить
     */
    public void removeAnimal(final Animal value) {
        if (isInList(value)) animals.remove(value);
        else throw new IllegalArgumentException(String.format("Такого животного: '%s' не существует", value));
    }


    /**
     * @return всех животных
     */
    public List<Animal> getAllAnimals() {
        return animals;
    }

    /**
     * Получить животное по названию
     *
     * @param name - название животного
     * @return - искомое животное
     */
    public Animal getAnimalWithName(final String name) {
        return animals.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Получить животных по соответствующему типу
     *
     * @param type - тип животного из enum
     * @return - список животных с соответствующим типом
     */
    public List<Animal> getAnimalsByType(final AnimalType type) {
        return switch (type) {
            case LION, TIGER, HIPPOPOTAMUS, MONKEY, GIRAFFE -> animals.stream()
                    .filter(e -> e.getType() == type)
                    .toList();
        };
    }

    /**
     * Поиск самого старого животного
     *
     * @return - вернуть самое старое животное, первое, какое попадется
     */
    public Animal oldestAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Поиск животное с самым длинным именем
     *
     * @return - возвращаем животное с самым длинным именем
     */
    public Animal longestNameAnimal() {
        return animals.stream()
                .max(Comparator.comparingInt(o -> o.getName().length()))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Сортировка по возрасту
     *
     * @return - отсортированный список по возрастанию возраста
     */
    public List<Animal> sortAnimalByAge() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getAge))
                .toList();
    }

    /**
     * Сортировка по имени
     *
     * @return - отсортированный список по алфавиту
     */
    public List<Animal> sortAnimalByName() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .toList();
    }

    /**
     * Проверка существует ли животное в списке
     *
     * @param value - Животное, которое необходимо проверить
     * @return - возвращается true/false в соответствии с существованием
     */
    private boolean isInList(final Animal value) {
        return animals.stream()
                .anyMatch(value::equals);
    }
}

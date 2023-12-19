![Жизненный цикл теста.png](https://i.ibb.co/gwrNjmc/image.png)

---
## Основный аннотации
> #### @BeforeAll - действие происходит 1 раз, перед всеми тестами.
> #### @BeforeEach - действие происходит каждый раз, перед запуском нового теста.
> #### @AfterEach - действие происходит после каждого теста.
> #### @AfterAll - действие происходит 1 раз после всех тестов.
> #### @Test - аннотация показывающая системе, что этот метод должен запускаться как тест.
## Дополнительные аннотации
> #### @ParameterizedTest - используется, когда необходимо передать набор параметров в тест.

> #### @ValueSource - используется для передачи параметра в тест.
> #### @NullSource - единственный способ передавать Null значения.
> #### @EmptySource - позволяет положить значения 'empty', не путать с null.
> #### @NullAndEmptySource - сочетает в себе функциональность @NullSource и @EmptySource.
> #### @EnumSource - удобный способ для использования enum констант.
> #### @MethodSource - способ для использования фабричных методов, метод помещаемый в аннотацию должен быть static.
> #### @CsvSource - используется для передачи нескольких параметров в тестовый метод, разделенные запятыми.
> #### @ArgumentsSource - используется для передачи собственного класса в параметр.
#### @ValueSource - используется для передачи параметра в тест.

 ```java
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testValueSource(int argument) {
        // Теперь при запуске теста в 'argument' будут передаваться значение от 1 до 3.
    }
```
#### @NullSource - единственный способ передавать Null значения.
```java
    @ParameterizedTest
    @NullSource
    void testNullSource(String argument) {
        assertTrue(argument == null);
    }
```
#### @EmptySource - позволяет положить значения 'empty', не путать с null.
```java
    @ParameterizedTest
    @EmptySource
    void testEmptySource(String argument) {
        assertTrue(StringUtils.isBlank(argument));
    }
```
#### @NullAndEmptySource - сочетает в себе функциональность @NullSource и @EmptySource.
```java
    @ParameterizedTest
    @NullAndEmptySource
    void testNullAndEmptySource(String argument) {
        assertTrue(StringUtils.isBlank(argument));
    }
```
#### @EnumSource - удобный способ для использования enum констант.
```java
    enum Direction {
    EAST, WEST, NORTH, SOUTH
    }

    @ParameterizedTest
    @EnumSource(Direction.class)
    void testEnumSource(Direction d) {
        assertNotNull(d);
    }
```
#### @MethodSource - способ для использования фабричных методов, метод помещаемый в аннотацию должен быть static.
```java
    @ParameterizedTest
    @MethodSource("argsFactory")
    void testMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> argsFactory() {
        return Stream.of("Петя", "Игорь");
    }
```
#### @MethodSource - если не передавать параметр, то поиск будет произведен в метод с таким же названием.
```java
    @ParameterizedTest
    @MethodSource
    void testMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testMethodSource() {
        return Stream.of("Петя", "Игорь");
    }
```
#### @CsvSource - используется для передачи нескольких параметров в тестовый метод, разделенные запятыми.
```java
    @ParameterizedTest
    @CsvSource(value = {
        "Петя, 14",
        "Игорь, 22",
        "Лиза, 32"
    }, ignoreLeadingAndTrailingWhitespace = true) // Свойство для указания учитывать пробелы или нет
    void testWithCsvSource(String name, int age) {
        assertNotNull(name);
        assertTrue(age > 0);
    }
```
#### @ArgumentsSource - используется для передачи собственного класса в параметр.
```java
    @ParameterizedTest
    @ArgumentsSource(AnimalArgumentsProvider.class)
        void testArgumentsSource(Animal animal) {
        assertTrue(animal.getAge() < 15);
    }

class AnimalArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new Anima("Жираф", 5)),
                Arguments.of(new Anima("Обезьяна", 1)),
                Arguments.of(new Anima("Гиппопотам", 7))
        );
    }
}
```
#### @ArgumentsSource - так же способен передавать несколько аргументов.
```java
    @ParameterizedTest
    @ArgumentsSource(AnimalArgumentsProvider.class)
    void testArgumentsSource(Animal animal, LocalDate date) {
        assertTrue(animal.getAge() < 15);
        assertNotNull(date);
    }

    class AnimalArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new Anima("Жираф", 5), LocalDate.of(2018, Month.APRIL, 10)),
                    Arguments.of(new Anima("Обезьяна", 1), LocalDate.of(2022, Month.SEPTEMBER, 22)),
                    Arguments.of(new Anima("Гиппопотам", 7), LocalDate.of(2016, Month.JULY, 5))
            );
        }
    }
```

---
## Задания
> #### 1. Протестировать весь функционал класса Zoo.

> #### 2. Создать класс `Car` с набором параметров `title, color, doorNum, price, brand`
> #### 2.1 `Brand` - сделать `Enum` и положить туда возможные марки авто.
> #### 2.3 Создать класс `Dealership` в котором прописать логику:
> #### Добавление нового авто - в качестве хранилища внутри класса `Dealership` использовать `Map` в которой хранить `Car` и `count`,
> #### Продажа,
> #### Поиск авто по названию,
> #### Получение списка всех автомобилей,
> #### Найти авто, определенной марки,
> #### Расчет скидки для постоянных покупателей в 10%
> #### Протестировать полученные методы.

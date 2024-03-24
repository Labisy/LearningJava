package org.task2;

class TestInfo {

}

//class TestInfo { Переделать
//
//    @Test
//    void textTesting() {
//        assertThat("The lord of the ring")
//                .isNotNull()
//                .startsWith("The")
//                .contains("lord")
//                .endsWith("ring");
//    }
//
//    @Test
//    @DisplayName("Проверка на совпадение возраста")
//    void ageTesting() {
//        Person person = new Person("frodo", 33, Race.HOBBIT);
//        assertThat(person.getAge()).as("check %s age", person.getName())
//                .isEqualTo(100);
//    }
//
//    @Test
//    @DisplayName("Проверка на совпадение имени")
//    void nameTesting() {
//        Person person = new Person("frodo", 33, Race.HOBBIT);
//        assertThat(person.getName()).withFailMessage("Должно быть %s name", person.getName())
//                .isEqualTo("100");
//    }
//
//    @Test
//    @DisplayName("satisfy")
//    void satisfy() {
//        Person frodo = new Person("frodo", 33, Race.HOBBIT);
//        Person sam = new Person("sam", 22, Race.HOBBIT);
//        List<Person> hobbits = List.of(frodo, sam);
//
//        Assertions.assertThat(hobbits).allSatisfy(character -> {
//            assertThat(character.getRace()).isEqualTo(Race.HOBBIT);
//            assertThat(character.getName()).isNotEqualTo("Гендальф");
//        });
//
//        Assertions.assertThat(hobbits).anySatisfy(character -> {
//            assertThat(character.getRace()).isEqualTo(Race.HOBBIT);
//            assertThat(character.getName()).isNotEqualTo("sam");
//        });
//
//        Assertions.assertThat(hobbits).noneSatisfy(character -> {
//            assertThat(character.getRace()).isEqualTo(Race.HUMAN);
//        });
//    }
//
//    @Test
//    void isNotNullOrEmpty() {
//        List<String> list = new ArrayList<>();
//
//        Assertions.assertThat(list)
//                .isNotNull()
//                .isNotEmpty();
//    }
//
//    @Test
//    void containTesting() {
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        Assertions.assertThat(list)
//                .contains("a") // элемент содержится в списке?
//                .contains("a", Index.atIndex(0)) // под 0 индексом лежит буква 'а'?
//                .containsOnlyOnce("a", "b", "c") // список состоит только из этих слов?
//                .containsAnyOf("t", "b") // есть ли хотя бы 1 слово в списке?
//                .containsExactlyInAnyOrder("c", "b", "a") // есть ли в списке такие символы, не учитывая порядок?
//                //.isSorted() // проверка, что элементы лежат по возрастанию
//                //.isSortedAccordingTo(Comparator.reverseOrder()) // проверка, что элементы отсортированы по компоратору
//                // (o1, o2) -> o1 - o2 => по возрастанию Comparator.naturalOrder();
//                // (o1, o2) -> o2 - o1 => по убыванию (Comparator.reverseOrder())
//        ;
//    }
//
//    @Test
//    void mapContainsTesting() {
//        Map<String, String> map = new HashMap<>();
//        map.put("a", "1");
//        map.put("b", "2");
//        map.put("c", "3");
//
//        Assertions.assertThat(map)
//                .containsKeys("a", "b", "c") // содержит ключи
//                .containsValues("1", "2", "3") // содержит значения
//                .hasEntrySatisfying("b", String::isEmpty); // удовлетворяет условию
//        ;
//    }
//
//    @Test
//    void dateTesting() {
//        LocalDate date = LocalDate.of(2024, 2, 21);
//
//        assertThat(date)
//                .isBetween("2024-01-20","2024-03-20") // находится между датами?
//                .isBefore("2024-02-22") // находится перед этой датой?
//                .isBeforeOrEqualTo("2024-02-21") // находится перед этой датой или ей равна?
//                .isEqualTo("2024-02-21") // равна дате?
//        ;
//    }
//
//    @Test
//    void personTestng() {
//        Person person = new Person("Игорь", 20, Race.HUMAN);
//        Person person2 = new Person("Иван", 20, Race.HUMAN);
//
//        List<Person> people = new ArrayList<>();
//        people.add(person);
//        people.add(person2);
//
//        Assertions.assertThat(people)
//                .extracting("name")
//                .containsOnlyOnce("Игорь", "Иван");
//    }
//}
//
//class Person {
//    private String name;
//    private int age;
//    private Race race;
//
//    public Person(String name, int age, Race race) {
//        this.name = name;
//        this.age = age;
//        this.race = race;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Race getRace() {
//        return race;
//    }
//
//    public void setRace(Race race) {
//        this.race = race;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name) && race == person.race;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, race);
//    }
//}
//
//enum Race {
//    HUMAN, HOBBIT
//}
<p align="center"><img src="https://i.ibb.co/4NbbPCj/stream.jpg" alt="Принцип работы stream"></p>

---
## Информация
Это способ работать со структурами данных Java, чаще всего `коллекциями`, в стиле функциональных языков программирования. Он помогает значительно сократить код и упростить его написание.\
Для реализации такого подхода используются `лямбда` выражения и интерфейс `stream`.

Пример:
```java
public static void main(String[] args) {
    // Создаем список данных
    List<Integer> integers = new ArrayList<>(List.of(10, 2, 5, 3, 7, 11));

    List<Integer> result = new ArrayList<>();
    for (int elem : integers) {
        int temp = elem + 1;

        if (temp > 5) {
            result.add(temp);
        }
    }
    System.out.println(result); // [11, 6, 8, 12]

    List<Integer> streamResult = integers.stream()
            .map(e -> e + 1)
            .filter(e -> e > 5)
            .toList();
    System.out.println(streamResult); // [11, 6, 8, 12]
}
```

---
## Операции
 В основе stream лежат два типа операций: 
> Конвейерные - их можно использовать друг за другом безграничное число раз.
> Терминальные - их можно использовать только один раз, в конце, как правило, они что-то возвращают.
### Конвейерные:
Для всех методов в качестве примера массива будет использоваться:\
`List<String> elements = new ArrayList<>(List.of("a", "b", "c", "d"));`

> filter() - используется для фильтрации значения по определенному признаку (аналог if).

Пример:
```java

```
> map() - используется для преобразования элементов stream.
>  
>  
>  
>  
> 
> 
> 

---

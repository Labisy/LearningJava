package org.lessons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateField {

    private LocalDate currentDate;

    public void addDate(String date) {
        // Вариант с ручным разбиением на массив и заполнение вручную.
//        String[] newDate = date
//                .replaceAll("[.-]", " ") // 12 03 2020
//                .split(" "); // [12, 03, 2020]
//        int day = Integer.parseInt(newDate[0]);
//        int month = Integer.parseInt(newDate[1]);
//        int year = Integer.parseInt(newDate[2]);
//
//        currentDate = LocalDate.of(day, month, year);

        DateTimeFormatter tempFormatter;
        switch (date.charAt(4)) {
            case '-':
                tempFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                break;
            case '.':
                tempFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                break;
            case '/':
                tempFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                break;
            default:
                System.out.println("Такого символ не учитывается");
                return;
        }

        try {
            currentDate = LocalDate.parse(date, tempFormatter);
        } catch (Exception e) {
            System.out.println("Невозможно конвертировать дату " + date);
        }
    }

    public String getDate() {
        return currentDate.toString();
    }

    public static void main(String[] args) {
        DateField field = new DateField();

        field.addDate("2020.12.03");
        System.out.println(field.getDate());
    }
}

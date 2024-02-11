package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*  Дано текстовий файл file.txt, в якому є список номерів телефонів (один рядок - один телефон).
    Необхідно написати метод, який буде читати файл, і виводити в консоль всі валідні номери телефонів.
    Телефон вважається валідним, якщо він відповідає одному з двох форматів (x - це одна цифра):
    (xxx) xxx-xxxx
    xxx-xxx-xxxx
 */
public class Task1 {
    public static void readFile(String file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.matches("((\\(\\d{3}\\)\\s)|(\\d{3}-))\\d{3}-\\d{4}")){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

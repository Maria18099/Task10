package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*  Є текстовий файл file.txt. Необхідно прочитати файл, перетворити його в список об'єктів типу User, і записати їх у новий файл user.json.
    Формат файлу:
    перший рядок - заголовок
    кожний наступний рядок - окремий об'єкт, кожна колонка розділена пробілом
        Приклад:
        Для файлу file.txt із вмістом:
        name age
        alice 21
        ryan 30
    необхідно створити наступний файл user.json.
 */
public class Task2 {
    public static List<User> readFile2(String file) {
        List<User> userList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line=bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] user = line.split("\\s");
                userList.add(new User(user[0], Integer.parseInt(user[1])));
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }
    public static void writeToJsonFile(List<User> userList, String file){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String text = gson.toJson(userList);
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

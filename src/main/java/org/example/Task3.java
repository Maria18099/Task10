package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*  Напишіть метод, який буде рахувати частоту кожного слова у файлі words.txt.
    Вважаємо що:
    words.txt містить лише слова в нижньому регістрі, розділені пробілом
    Кожне слово містить лише літери в нижньому регістрі
    Слова розділені одним або декількома пробілами, або переносом рядка
        Приклад:
        Для файлу words.txt із вмістом:
        the day is sunny the the
        the sunny is is
    Метод повинен повернути результат на кшталт:
        the 4
        is 3
        sunny 2
        day 1
    Результат виводу в консоль повинен бути відсортований за частотою
        (спочатку йдуть слова, що зустрічаються найчастіше)
 */
public class Task3 {
    public static void frequencyOfWords(String file){
        //Читаємо файл та отримуємо список слів
        List<String> words = readFile(file);
        //Рахуємо частоту слів та зберігаємо в map
        Map<String,Integer> frequency = calculateFrequency(words);
        //Сортуємо слова по частоті та виводимо на екран
        sortEntriesAndPrint(frequency);
    }

    private static List<String> readFile(String file){
        List<String> words= new ArrayList<>();
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while ((line = bufferedReader.readLine())!=null){
                //зчитуємо рядок та ділимо його на слова
                String[] lineWords = line.split("\\s");
                //переписуємо рядок в arrayList
                for (String word: lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
    private static Map<String,Integer> calculateFrequency(List<String> words){
        Map<String, Integer> wordFrequency = new HashMap<>();
        // Підрахунок частоти слів
        for (String word : words) {
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }
        return wordFrequency;
    }
    private static void sortEntriesAndPrint(Map<String, Integer> frequency) {
        List<Map.Entry<String,Integer>> list = new ArrayList<>(frequency.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String,Integer> word:
                list) {
            System.out.println(word.getKey()+" "+word.getValue());
        }
    }

}

package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task1 result:");
        Task1.readFile("file1.txt");
        //Task 2
        List<User> list = Task2.readFile2("file2.txt");
        Task2.writeToJsonFile(list,"user.txt");
        //Task 3
        System.out.println("Task3 result:");
        Task3.frequencyOfWords("words.txt");
    }

}
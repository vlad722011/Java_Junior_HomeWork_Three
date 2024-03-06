package task1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
           1. Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.
        */

        System.out.println("Task_One:");

        Person person = new Person("Ivan", 25);

        try (FileOutputStream fos = new FileOutputStream("personData.bin");
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(person);
            System.out.println("Объект 'person' сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("personData.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            person = (Person) objectInputStream.readObject();
            System.out.println("Объект 'person.bin' десериализован.");
        }

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
    }
}

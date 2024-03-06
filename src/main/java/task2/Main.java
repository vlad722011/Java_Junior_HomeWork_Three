package task2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
         2. Разработайте класс Student с полями String name, int age, transient double GPA(средний балл). Обеспечьте поддержку
            сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными. Сериализуйте этот объект
            в файл. Десериализуйте обратно объект в программу из файла. Выведите все поля объекта включая GPA, и обсудите почему
           значение GPA не было сохранено / восстановлено.
         */

        System.out.println("Task_Three:");

        Student studentIvanov = new Student("Ivanov Ivan", 19, 4.75);

        try (FileOutputStream fileOutputStream = new FileOutputStream("studentIvanovInfo.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(studentIvanov);
            System.out.println("Объект 'studentIvanov' сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("studentIvanovInfo.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            studentIvanov = (Student) objectInputStream.readObject();
            System.out.println("Объект 'studentIvanovInfo.bin' десериализован.");
        }

        System.out.println("Имя: " + studentIvanov.getName());
        System.out.println("Возраст: " + studentIvanov.getAge());
        System.out.println("Средний балл: " + studentIvanov.getGPA());

        /*
        При десериализации не сможем получить средний бал студента Иванова, так значение поля при создании класса
        Student установлено transient.
         */
    }
}

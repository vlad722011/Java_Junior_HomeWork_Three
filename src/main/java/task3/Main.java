package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        /*
         3. Выполнить задачу 2 используя другие типы сериализации (в xml и json документы).
         */

        Student student = new Student("Petrov Petr", 51, 4.05);
        System.out.println(student.toString());


        final ObjectMapper objectMapper = new ObjectMapper();
        final XmlMapper xmlMapper = new XmlMapper();


        // Сериализуем объект 'student' (Petrov Petr, 51, 4.05) в JSON документ

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File("studentInfo.json"), student);
        System.out.println("Объект сериализован в json файл!");

        // Десериализуем объект 'studentinfo.json' в объект класса Student

        File fileJson = new File("studentInfo.json");
        student = objectMapper.readValue(fileJson, Student.class);
        System.out.println("Объект десериализован из json файла!");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());



        // Сериализуем объект student (Petrov Petr, 51, 4.05) в XML документ

        xmlMapper.writeValue(new File("studentInfo.xml"), student);
        System.out.println("Объект сериализован в xml файл!");



        // Десериализуем объект 'studentinfo.xml' в объект класса Student

        File fileXml = new File("studentInfo.xml");
        student = xmlMapper.readValue(fileXml, Student.class);
        System.out.println("Объект десериализован из json файла!");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());
    }


}


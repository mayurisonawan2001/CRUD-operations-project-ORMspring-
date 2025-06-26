package com.console.main;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.console.dao.StudentDao;
import com.console.entity.Student;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to Spring ORM Application");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Get Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter City: ");
                    String city = sc.next();
                    Student s = new Student(id, name, city);
                    studentDao.insert(s);
                    System.out.println("Student added.");
                    break;

                case 2:
                    List<Student> all = studentDao.getAllStudents();
                    for (Student st : all) System.out.println(st);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student found = studentDao.getStudent(sc.nextInt());
                    System.out.println(found);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    studentDao.delete(sc.nextInt());
                    System.out.println("Deleted.");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String uname = sc.next();
                    System.out.print("Enter City: ");
                    String ucity = sc.next();
                    Student us = new Student(uid, uname, ucity);
                    studentDao.update(us);
                    System.out.println("Updated.");
                    break;

                case 6:
                    sc.close();
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }
}

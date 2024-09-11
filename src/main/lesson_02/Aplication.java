import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplication {


    public static void main(String[] args)  throws SQLException{

        Scanner scanner = new Scanner(System.in);
        CoursesDao coursesDao = new CoursesDao(ConnectionDataBase.getConnection());

        while (true){
            System.out.println("Введіть дію" + '\n'
            + "1. Добавити курс" + '\n'
            + "2. Переглянути курси" + '\n'
            + "3. Видалити курс" + '\n'
            + "4. Змінити курс");

            if (scanner.hasNext()){
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:{
                        System.out.println("Введіть ім'я");
                        String name = scanner.next();
                        System.out.println("Введіть кількість уроків");
                        int count = scanner.nextInt();
                        Courses courses = new Courses(name, count);
                        coursesDao.create(courses);
                        break;
                    }
                    case 2:{
                        coursesDao.read().stream().forEach(System.out::println);
                        break;
                    }
                    case 3:{
                        System.out.println("Вевідіть номер курсу");
                        int id = scanner.nextInt();
                        coursesDao.delete(id);
                        break;
                    }
                    case 4:{
                        System.out.println("Введіть ім'я");
                        String name = scanner.next();
                        System.out.println("Введіть кількість уроків");
                        int count = scanner.nextInt();
                        System.out.println("Вевідіть номер курсу");
                        int id = scanner.nextInt();
                        Courses courses = new Courses(name, count,id);
                        coursesDao.update(courses);
                        break;
                    }
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                        scanner.close();
                }

                }

            }
        }


    }


package com.sagar;

import com.sagar.relationship.Laptop;
import com.sagar.relationship.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Alien alien = new Alien();

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Alien.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
//    saveAlien(session);
//
//    alien = fetchAlien(session);
//    System.out.println(alien);
        Laptop laptop = new Laptop();
        Laptop laptop2 = new Laptop();
        Laptop laptop3 = new Laptop();
        List<Laptop> laptops = new ArrayList<>();
        List<Laptop> laptops2 = new ArrayList<>();
        List<Laptop> laptops3 = new ArrayList<>();

        laptop.setId(1);
        laptop.setBrand("Dell");

        laptop2.setId(2);
        laptop2.setBrand("Sam");

        laptop3.setId(3);
        laptop3.setBrand("Harry");

        laptops.add(laptop);
        laptops.add(laptop2);
        laptops.add(laptop3);

        laptops2.add(laptop);
        laptops2.add(laptop2);

        laptops3.add(laptop);
        laptops3.add(laptop3);


        Student student = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        List<Student> students = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();

        student.setId(1);
        student.setName("Sagar");

        student2.setId(2);
        student2.setName("Hari");

        student3.setId(3);
        student3.setName("Ritu");

        students.add(student);
        students.add(student2);
        students.add(student3);
//    student.setLaptop(laptops);

        student.setLaptops(laptops);
        student2.setLaptops(laptops2);
        student3.setLaptops(laptops3);
        laptop.setStudents(students);
        laptop2.setStudents(students2);
        laptop3.setStudents(students3);

        saveStudent(session, students);
//        laptop.setStudent(student);

        saveLaptop(session, laptops);

    }

    public static void saveStudent(Session session, List<Student> student) {
        Transaction transaction = session.beginTransaction();
        for (Student s : student) {
            session.save(s);
        }
        transaction.commit();
    }

    public static void saveLaptop(Session session, List<Laptop> laptop) {
        Transaction transaction = session.beginTransaction();
        for (Laptop l : laptop) {
            session.save(l);
        }
        transaction.commit();
    }

    public static void saveAlien(Session session) {
        AlienName alienName = new AlienName();
        alienName.setfName("Sagar");
        alienName.setmName("Kumar");
        alienName.setlName("Shrestha");

        Alien alien = new Alien();
        alien.setAlienId(1);
        alien.setAlienName(alienName);
        alien.setAlienColor("Blue");

        Transaction transaction = session.beginTransaction();
        session.save(alien);
        transaction.commit();
    }

    public static Alien fetchAlien(Session session) {
        Transaction transaction = session.beginTransaction();
        Alien alien;
        alien = (Alien) session.get(Alien.class, 1);
        transaction.commit();
        return alien;
    }
}
